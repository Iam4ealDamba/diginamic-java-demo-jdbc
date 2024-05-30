package fr.diginamic.dao;

import java.sql.ResultSet;
import java.util.List;

import fr.diginamic.config.MyDatabase;
import fr.diginamic.jdbc.entities.Member;

public class MemberDaoJdbc implements MemberDAO {
  MyDatabase db;

  public MemberDaoJdbc(MyDatabase db) {
    this.db = db;
  }

  @Override
  public List<Member> extraire() {
    try {
      ResultSet rs = db.getConnection().createStatement().executeQuery("SELECT * FROM member");
      List<Member> members = new java.util.ArrayList<>();

      while (rs.next()) {
        members.add(new Member(rs.getString("name"), rs.getInt("id")));
      }

      return members;
    } catch (Exception e) {
      System.out.println("An error occured on DB select: " + e.getMessage());
      return null;
    }
  }

  @Override
  public void insert(Member member) {
    try {
      db.getConnection().createStatement()
          .executeUpdate("INSERT INTO member (name) VALUES ('" + member.getName() + "')");
      System.out.println("Member inserted");
    } catch (Exception e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
    }
  }

  @Override
  public int update(String ancienNom, String nouveauNom) {
    try {
      return db.getConnection().createStatement()
          .executeUpdate("UPDATE member SET name = '" + nouveauNom + "' WHERE name = '" + ancienNom + "'");
    } catch (Exception e) {
      System.out.println("An error occured on DB update: " + e.getMessage());
      return 0;
    }
  }

  @Override
  public boolean delete(Member member) {
    try {
      return db.getConnection().createStatement()
          .executeUpdate("Delete FROM member WHERE id = " + member.getId()) == 1;
    } catch (Exception e) {
      System.out.println("An error occured on DB delete: " + e.getMessage());
      return false;
    }
  }

}
