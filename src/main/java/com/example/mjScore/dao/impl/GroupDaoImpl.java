package com.example.mjScore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mjScore.dao.GroupDao;
import com.example.mjScore.model.GroupBean;
import com.example.mjScore.model.MemberBean;


@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	EntityManager em;
	
	//儲存隊伍資料
	@Override
	public void saveGroup(GroupBean gb) {
		em.persist(gb);
	}
	
	//登入檢查
	@SuppressWarnings("unchecked")
	@Override
	public GroupBean checkLogin(String account, String password) {
		GroupBean gb = null;
		String hql = "FROM GroupBean g WHERE g.groupAccount = :account AND g.password = :password";
		List<GroupBean> bean = em.createQuery(hql).setParameter("account", account).setParameter("password", password).getResultList();
		if(bean.size()>0) {
			gb = bean.get(0);
		}
		return gb;
	}

	@Override
	public boolean accountExists(String account) {
		boolean exist = false;
		String hql = "FROM GroupBean g WHERE g.groupAccount = :account";
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
	public List<MemberBean> getMembersByTeamId(int id) {
		String hql = "FROM MemberBean m WHERE m.groupId = :id ORDER BY m.score DESC";
		return em.createQuery(hql).setParameter("id", id).getResultList();
//		return em.find(GroupBean.class, id);
	}

	@Override
	public void updateMemberScore(int id,int score) {
		String hql = "UPDATE MemberBean  m SET m.score = :score WHERE m.memberId = :id";
		em.createQuery(hql).setParameter("score", score).setParameter("id", id).executeUpdate();
	}
	
}
