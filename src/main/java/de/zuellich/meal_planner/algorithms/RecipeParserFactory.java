package de.zuellich.meal_planner.algorithms;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Entry point to parsing a source. */
@Service
public class RecipeParserFactory {

  private final Set<FormatDetector> formatDetectors;

  @Autowired
  public RecipeParserFactory(Set<FormatDetector> formatDetectors) {
    this.formatDetectors = formatDetectors;
  }

  /**
   * Get a parser instance for the provided source.
   *
   * @param source The source that is supplied to the format detector.
   * @return A parser instance that can parse the sauce.
   */
  public RecipeParser getParser(String source) {
    for (FormatDetector formatDetector : formatDetectors) {
      if (formatDetector.isSupported(source)) {
        return formatDetector.getParserInstance();
      }
    }

    return new NullParser();
  }
}
