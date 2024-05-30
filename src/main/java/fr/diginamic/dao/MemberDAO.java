package fr.diginamic.dao;

import java.util.List;

import fr.diginamic.jdbc.entities.Member;

public interface MemberDAO {
  List<Member> extraire();

  void insert(Member member);

  int update(String ancienNom, String nouveauNom);

  boolean delete(Member member);
}
