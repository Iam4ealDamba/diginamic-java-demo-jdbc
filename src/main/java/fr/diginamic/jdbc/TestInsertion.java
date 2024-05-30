package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.config.MyDatabase;

public class TestInsertion {
  public static void main(String[] args) {
    MyDatabase db = new MyDatabase();

    // Insert new member
    try {
      db.getConnection()
          .createStatement()
          .executeUpdate(
              "INSERT INTO member (name) VALUES ('La Maison de la Peinture')");
    } catch (SQLException e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
    }

    db.close();
  }
}
