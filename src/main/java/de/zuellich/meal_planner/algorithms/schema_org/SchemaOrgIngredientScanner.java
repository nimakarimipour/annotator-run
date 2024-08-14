package de.zuellich.meal_planner.algorithms.schema_org;

import de.zuellich.meal_planner.algorithms.AmountParser;
import de.zuellich.meal_planner.algorithms.IngredientScanner;
import de.zuellich.meal_planner.algorithms.IngredientUnitLookup;
import de.zuellich.meal_planner.datatypes.Ingredient;
import de.zuellich.meal_planner.datatypes.IngredientUnit;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

/** Returns a list of ingredients based on XML. */
@Component
public class SchemaOrgIngredientScanner implements IngredientScanner {

  private final IngredientUnitLookup ingredientUnitLookup;
  private final AmountParser amountParser;

  /**
   * Create a new instance.
   *
   * @param amountParser Used to parse amounts for the ingredients.
   * @param ingredientUnitLookup Used to lookup the units for an ingredient.
   */
  public SchemaOrgIngredientScanner(
      AmountParser amountParser, IngredientUnitLookup ingredientUnitLookup) {
    this.amountParser = amountParser;
    this.ingredientUnitLookup = ingredientUnitLookup;
  }

  @Override
  public List<Ingredient> parse(String source) {
    Document document = Jsoup.parse(source);
    Elements ingredients = getIngredientElements(document);

    List<Ingredient> result = new ArrayList<>(ingredients.size());
    for (Element ingredient : ingredients) {
      result.add(parseIngredient(ingredient));
    }

    return result;
  }

  /**
   * Extract a list of ingredient elements from the given document. This method should be
   * overwritten by other parsers that require a different selector to be used.
   *
   * @param document The document to extract ingredients from.
   * @return An empty Elements if none found.
   */
  protected Elements getIngredientElements(Document document) {
    return document.getElementsByAttributeValue("itemprop", "recipeIngredient");
  }

  /**
   * Method is called to extract an Ingredient instance from the elements gathered by
   * getIngredientElements.
   *
   * @param ingredient The element representing an element.
   * @return An ingredient instance.
   */
  protected Ingredient parseIngredient(Element ingredient) {
    Elements typeElement = ingredient.select(".wprm-recipe-ingredient-name");
    Elements amountElement = ingredient.select(".wprm-recipe-ingredient-amount");
    Elements ingredientElement = ingredient.select(".wprm-recipe-ingredient-unit");

    String type = typeElement.text();
    float amount = amountParser.parseAmount(amountElement.text());
    IngredientUnit ingredientUnit = ingredientUnitLookup.lookup(ingredientElement.text());

    return new Ingredient(type, amount, ingredientUnit);
  }

  public IngredientUnitLookup getIngredientUnitLookup() {
    return ingredientUnitLookup;
  }

  public AmountParser getAmountParser() {
    return amountParser;
  }
}
