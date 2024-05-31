package fr.diginamic.dao;

import fr.diginamic.config.MyDatabase;

public class DemoDAO {
  public static void main(String[] args) {
    MyDatabase db = new MyDatabase();
    MemberDaoJdbc dao = new MemberDaoJdbc(db);

    dao.extraire();
  }
}
