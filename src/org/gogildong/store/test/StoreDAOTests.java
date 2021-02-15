package org.gogildong.store.test;

import java.util.List;

import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.store.dao.StoreDAO;
import org.gogildong.store.domain.Store;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class StoreDAOTests {

	private StoreDAO dao;
	
	@Before
	public void ready() {
		dao = new StoreDAO();
	}
	
	@Test
	public void testSqlSessioFactory() {
		//  			설정파링이 로딩이 끝난걸 확인
		System.out.println(MyBatisMaker.INSTANCE.getFactory());
		
	}
	
	@Test
	public void testGetAll() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(1);
		pageInfo.setPerSheet(3);
		List<Store> stores = dao.getAll(pageInfo);
		
		stores.forEach(store -> log.info(store));
	}
	
	@Test
	public void testGetOne() {
		
		Store store = dao.getOne(44L);
		
		System.out.println(store);
	}
	
	@Test
	public void testInsert() {
		
		Store store = Store.builder()
				.name("쉑쉑버거")
				.lat(31.123)
				.lng(127.123)
				.build();
		
		dao.insert(store);
	}
	
	@Test
	public void testDelete() {
		Long sno = 23L;
		
		dao.delete(sno);
		
	}
	
	@Test
	public void testUpdate() {
		Store store = dao.getOne(45L);
		
		store.setName("오류");
		
		dao.update(store);
		
	}
	
	@Test
	public void testRcount() {
		Long sno = 4L;
		
		int num = dao.getRcount(sno);
		
		System.out.println(num);
	}
	
}
