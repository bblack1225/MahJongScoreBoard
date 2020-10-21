package com.example.mjScore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mjScore.dao.GroupDao;
import com.example.mjScore.model.Group;
import com.example.mjScore.model.Member;


@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	EntityManager em;
	
	//儲存隊伍資料
	@Override
	public void saveGroup(Group gb) {
		em.persist(gb);
	}
	
	//登入檢查
	@SuppressWarnings("unchecked")
	@Override
	public Group checkLogin(String account, String password) {
		Group gb = null;
		String hql = "FROM Group g WHERE g.groupAccount = :account AND g.password = :password";
		List<Group> bean = em.createQuery(hql).setParameter("account", account).setParameter("password", password).getResultList();
		if(bean.size()>0) {
			gb = bean.get(0);
		}
		return gb;
	}

	@Override
	public boolean accountExists(String account) {
		boolean exist = false;
		String hql = "FROM Group g WHERE g.groupAccount = :account";
		try {
			em.createQuery(hql)
			  .setParameter("account", account)
			  .getSingleResult();
			exist = true;
		} catch (NoResultException ex) {
			exist = false;
		}
		return exist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Member> getMembersByTeamId(int id) {
		String hql = "FROM Member m WHERE m.groupId = :id ORDER BY m.score DESC";
		return em.createQuery(hql).setParameter("id", id).getResultList();
//		return em.find(GroupBean.class, id);
	}

	@Override
	public void updateMemberScore(int id,int score) {
		String hql = "UPDATE Member  m SET m.score = :score WHERE m.memberId = :id";
		em.createQuery(hql).setParameter("score", score).setParameter("id", id).executeUpdate();
	}

	@Override
	public void updateLastTimePlay(Group gb) {
		String hql = "UPDATE Group g SET g.lastTimeToPlay = :time WHERE g.groupId = :id";
		em.createQuery(hql).setParameter("time", gb.getLastTimeToPlay()).setParameter("id", gb.getGroupId()).executeUpdate();
	}
	
	//該改成員名稱
	public void updateMemberName(Member mb) {
		String hql = "UPDATE Member m SET m.memberName = :name , m.score = :score WHERE m.memberId = :id";
		em.createQuery(hql).setParameter("name", mb.getMemberName()).setParameter("score", mb.getScore()).setParameter("id", mb.getMemberId()).executeUpdate();
	}
}
