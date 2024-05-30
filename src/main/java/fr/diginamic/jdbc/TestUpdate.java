package fr.diginamic.jdbc;

import java.sql.SQLException;

import fr.diginamic.config.MyDatabase;

public class TestUpdate {
  public static void main(String[] args) {
    MyDatabase db = new MyDatabase();

    // Update a member
    try {
      db.getConnection()
          .createStatement()
          .executeUpdate(
              "UPDATE member SET name = 'La Maison des Peintures' WHERE id = 1");
    } catch (SQLException e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
    }

    db.close();
  }
}
