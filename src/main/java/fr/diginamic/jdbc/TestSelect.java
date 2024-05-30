package fr.diginamic.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import fr.diginamic.config.MyDatabase;
import fr.diginamic.jdbc.entities.Member;

public class TestSelect {
  public static void main(String[] args) {
    MyDatabase db = new MyDatabase();

    // Select a member
    try {
      ResultSet rs = db.getConnection()
          .createStatement()
          .executeQuery("SELECT * FROM member WHERE id = 1");
      Member member = null;

      while (rs.next()) {
        member = new Member(rs.getString("name"), rs.getInt("id"));
      }

      System.out.println("Member found: \n" + member);
    } catch (SQLException e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
    }

    db.close();
  }
}
