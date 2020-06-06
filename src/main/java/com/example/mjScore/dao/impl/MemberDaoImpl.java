package com.example.mjScore.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mjScore.dao.MemberDao;
import com.example.mjScore.model.GroupBean;


@Repository
public class MemberDaoImpl implements MemberDao {

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

}
