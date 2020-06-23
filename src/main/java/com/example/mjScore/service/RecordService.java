package com.example.mjScore.service;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mjScore.dao.RecordRepository;
import com.example.mjScore.model.MemberRecord;
import com.example.mjScore.model.RecordData;

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
//	public MemberRecord getMemberRecords(int id) {
//		return repo.findById(id).get();
//	}
	
	@SuppressWarnings("unchecked")
//	public List<Integer> getMemberRecords(Integer id){
		public Map<String,Integer> getMemberRecords(Integer id){
//		Map<Integer,RecordData> map = new LinkedHashMap<Integer, RecordData>();
		Map<String,Integer> map = new LinkedHashMap<String, Integer>();
		String hql1 = "select r.winType from MemberRecord r where r.memberId = :id group by r.winType ORDER BY r.winType";
		String hql2 = "select count(r.winType) from MemberRecord r where r.memberId = :id AND r.winType = :typeId group by r.winType";
		String hql3 = "select w.typeName from WinTypeBean w where w.typeId = :typeId";
		List<Integer> list = em.createQuery(hql1).setParameter("id", id).getResultList();
		System.out.println("size" + list.size());
//		List<Integer> mapTolist = new ArrayList<>();
		int i = 1;
		while(i != 25) {
			String typeName = (String)em.createQuery(hql3).setParameter("typeId", i).getSingleResult();
			if(list.contains(i)) {
				//count的return 型態為Long 要再轉型
				Long countL = (long)em.createQuery(hql2).setParameter("id", id).setParameter("typeId", i).getSingleResult();
				int count = countL.intValue();
				map.put(typeName,count);
			}else {
				map.put(typeName,0);
			}
			i++;
		}		
		return map;
	}
	
}
