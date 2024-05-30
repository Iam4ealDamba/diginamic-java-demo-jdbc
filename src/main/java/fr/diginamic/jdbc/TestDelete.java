package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.config.MyDatabase;

public class TestDelete {
  public static void main(String[] args) {
    MyDatabase db = new MyDatabase();

    // Insert new user
    try {
      db.getConnection()
          .createStatement()
          .executeUpdate(
              "Delete FROM member WHERE id = 1");
    } catch (SQLException e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
    }

    db.close();
  }
}
