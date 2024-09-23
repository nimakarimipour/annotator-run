package de.zuellich.meal_planner.pinterest.datatypes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/** */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pin {

  /** Pinterest's unique identifier for this pin. */
  @Nullable private String id;

  /** The URL to the pinned page. */
  @JsonProperty("original_link")
  private String originalLink = "";

  @Nullable private String note;

  @Nullable private String name;

  public Pin() {}

  @JsonCreator
  public Pin(@JsonProperty("metadata") Map<String, Object> metadata) {
    if (metadata == null || !metadata.containsKey("article")) {
      this.name = "";
      return;
    }

    String name = "";
    Map<String, Object> article = (Map<String, Object>) metadata.get("article");

    if (article.containsKey("name")) {
      name = article.get("name").toString();
    } else {
      name = "";
    }

    this.name = name;
  }

  @Nullable public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOriginalLink() {
    return originalLink;
  }

  public void setOriginalLink(String originalLink) {
    this.originalLink = originalLink;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pin pin = (Pin) o;
    return Objects.equals(getId(), pin.getId())
        && Objects.equals(getOriginalLink(), pin.getOriginalLink());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getOriginalLink());
  }

  @Override
  public String toString() {
    return "Pin{" + "id='" + id + '\'' + ", originalLink='" + originalLink + '\'' + '}';
  }

  @Nullable public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Nullable public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
