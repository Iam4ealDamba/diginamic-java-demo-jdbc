package fr.diginamic.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.diginamic.config.MyDatabase;
import fr.diginamic.jdbc.entities.Member;

public class MemberDaoJdbc2 implements MemberDAO {
  MyDatabase db;

  public MemberDaoJdbc2(MyDatabase db) {
    this.db = db;
  }

  @Override
  public List<Member> extraire() {
    try {
      PreparedStatement ps = db.getConnection().prepareStatement("SELECT * FROM member");
      ResultSet rs = ps.executeQuery();
      List<Member> members = new java.util.ArrayList<>();

      if (!rs.next()) {
        System.out.println("No member found");
        return null;
      }

      while (rs.next()) {
        members.add(new Member(rs.getString("name"), rs.getInt("id")));
      }

      ps.close();
      return members;
    } catch (Exception e) {
      System.out.println("An error occured on DB select: " + e.getMessage());
      db.close();
      return null;
    }
  }

  @Override
  public void insert(Member member) {
    try {
      PreparedStatement ps = db.getConnection()
          .prepareStatement("INSERT INTO member (name) VALUES (?)");
      ps.setString(1, member.getName());
      ps.executeUpdate();
      System.out.println("Member inserted");
      ps.close();
    } catch (Exception e) {
      System.out.println("An error occured on DB insert: " + e.getMessage());
      db.close();
    }
  }

  @Override
  public int update(String ancienNom, String nouveauNom) {
    try {
      PreparedStatement ps = db.getConnection()
          .prepareStatement("UPDATE member SET name = ? WHERE name = ?");
      ps.setString(1, ancienNom);
      ps.setString(2, nouveauNom);
      ps.close();
      return ps.executeUpdate();
    } catch (Exception e) {
      System.out.println("An error occured on DB update: " + e.getMessage());
      db.close();
      return 0;
    }
  }

  @Override
  public boolean delete(Member member) {
    try {
      PreparedStatement ps = db.getConnection().prepareStatement("Delete FROM member WHERE id = ?");
      ps.setInt(1, member.getId());
      ps.executeUpdate();
      ps.close();
      return true;
    } catch (Exception e) {
      System.out.println("An error occured on DB delete: " + e.getMessage());
      db.close();
      return false;
    }
  }
}
