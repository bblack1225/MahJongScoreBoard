package com.example.mjScore.service;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.DateUtils;

import com.example.mjScore.model.MemberRecord;
import com.example.mjScore.repository.RecordRepository;

@Service
public class RecordService {
	
	@Autowired
	private RecordRepository repo;
	
	@Autowired
	EntityManager em;
	
	//儲存紀錄
	public void saveRecord(MemberRecord record) {
		 repo.save(record);
	}
	
	//找會員的紀錄
	@SuppressWarnings("unchecked")
		public Map<String,Integer> getMemberRecords(Integer id){
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		//找到會員有出現過哪些牌型
		String hql1 = "select r.winType from MemberRecord r where r.memberId = :id group by r.winType ORDER BY r.winType";
		//找到那些牌型的次數
		String hql2 = "select count(r.winType) from MemberRecord r where r.memberId = :id AND r.winType = :typeId group by r.winType";
		//因為存在紀錄那邊是用typeId 所以要依序透過ID找到中文的牌型名稱，呈現在前端要用的
		String hql3 = "select w.typeName from WinTypeBean w where w.typeId = :typeId";
		//出現過的牌型ID
		List<Integer> list = em.createQuery(hql1).setParameter("id", id).getResultList();
		int i = 1;
		//資料庫中的ID是1~24
		while(i != 27) {
			String typeName = (String)em.createQuery(hql3).setParameter("typeId", i).getSingleResult();
			//如果牌型名稱有包含在該隊員的牌型list中
			if(list.contains(i)) {
				//count的return 型態為Long 要再轉型(出現的牌型次數)
				Long countL = (long)em.createQuery(hql2).setParameter("id", id).setParameter("typeId", i).getSingleResult();
				int count = countL.intValue();
				map.put(typeName,count);
				//沒出現過就給他0次
			}else {
				map.put(typeName,0);
			}
			i++;
		}		
		return map;
	}
	
	//選擇不同日期的分數呈現方式
	@SuppressWarnings("unchecked")
	public Map<Integer,Integer> showSelectRecord(String dateSelect){
//		public List<Integer> showSelectRecord(String dateSelect){
		Map<Integer,Integer> map = new LinkedHashMap<>();
		List<Integer> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		//當天戰績
		if(dateSelect.equals("today")) {
			String hql = "SELECT m.memberId FROM MemberRecord m WHERE m.winTime = :currentDate ORDER BY m.memberId";
//			String hql = "SELECT sum(m.score) FROM MemberRecord m WHERE m.winTime between  GROUP BY m.memberId";
			
			list = em.createQuery(hql).setParameter("currentDate",sdf.format(date)).getResultList();
			for(int a : list) {
				System.out.println(a);
			}
		}
//		//當月戰績
//		else if(dateSelect.equals("thisMonth")) {
//			
//		}
//		//當年戰績
//		else if(dateSelect.equals("thisYear")){
//			
//		}else {
//			
//		}
		return map;
	}
	
}
