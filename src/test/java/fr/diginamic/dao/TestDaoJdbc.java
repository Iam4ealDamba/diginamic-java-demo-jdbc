package fr.diginamic.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import fr.diginamic.config.MyDatabase;
import fr.diginamic.jdbc.entities.Member;

public class TestDaoJdbc {
  @Test
  public void testInsert() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);
    Member member = new Member("France de matériaux");

    try {
      dao.insert(member);
      int count = 0;
      ResultSet rs = db.getConnection().createStatement().executeQuery("SELECT * FROM member");

      while (rs.next()) {
        count++;
      }

      assertEquals(1, count);
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }

  @Test
  public void testSelectAfterInsert() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);

    try {
      assertEquals(1, dao.extraire().size());
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }

  @Test
  public void testUpdate() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);
    Member member = dao.extraire().get(0);

    try {
      dao.update(member.getName(), "France matériaux");
      assertEquals("France matériaux", dao.extraire().get(0).getName());
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }

  @Test
  public void testDelete() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);
    Member member = dao.extraire().get(0);

    try {
      assertEquals(true, dao.delete(member));
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }

  @Test
  public void testSelectAfterDelete() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);

    try {
      assertEquals(0, dao.extraire().size());
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }

  @Test
  public void testInsertSingleQuote() {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);
    Member member = new Member("L’Espace Création");

    try {
      dao.insert(member);
      int count = 0;
      ResultSet rs = db.getConnection().createStatement().executeQuery("SELECT * FROM member");

      while (rs.next()) {
        count++;
      }

      assertEquals(1, count);
    } catch (Exception e) {
      System.out.println("An error occurred : " + e.getMessage());
    }
  }
}
