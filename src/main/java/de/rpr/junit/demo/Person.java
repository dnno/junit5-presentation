package de.rpr.junit.demo;

public class Person {

  private String firstname;
  private String lastname;

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Person{");
    sb.append("firstname='").append(firstname).append('\'');
    sb.append(", lastname='").append(lastname).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
