package ua.hillel.rest.entities;

import java.util.Objects;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class Pet {
  private long id;
  private String name;
  private String status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override public String toString() {
    return "Pet{" + "id=" + id + ", name='" + name + '\'' + ", status='" + status + '\'' + '}';
  }

  @Override public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Pet pet = (Pet) o;
    return Objects.equals(name, pet.name) && Objects.equals(status, pet.status);
  }

  @Override public int hashCode() {
    return Objects.hash(name, status);
  }
}
