package fr.diginamic.jdbc.entities;

public class Member {
  int id;
  String name;

  public Member(String name, int... id) {
    this.name = name;
    this.id = id.length > 0 ? id[0] : 0;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "{ id: " + id + ", name: \"" + name + "\" }";
  }

}
