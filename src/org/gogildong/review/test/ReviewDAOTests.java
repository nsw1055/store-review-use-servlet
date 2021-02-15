package org.gogildong.review.test;

import java.util.List;

import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.review.dao.ReviewDAO;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.gogildong.store.domain.Store;
import org.junit.Before;
import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReviewDAOTests {

	private ReviewDAO dao;
	private PageInfo pageInfo;
	
	@Before
	public void ready() {
		dao = new ReviewDAO();
		pageInfo = new PageInfo();
	}
	
	@Test
	public void testSqlSessioFactory() {
		//  			설정파링이 로딩이 끝난걸 확인
		System.out.println(MyBatisMaker.INSTANCE.getFactory());
		
	}
	
	@Test
	public void testGetReview() {
		pageInfo.setPage(1);
		pageInfo.setPerSheet(3);
		pageInfo.setSno(4L);
		List<Review> reviews = dao.getReview(pageInfo);
		
		reviews.forEach(review -> log.info(review));
	}
	
	@Test
	public void testGetOne() {
		
		Store store = dao.getStore(44L);
		
		System.out.println(store);
	}
	
	@Test
	public void testInsertLike() {
		
		Like like = Like.builder()
						.rno(197L)
						.mid("nsw")
						.build();
		dao.insertLike(like);
	
		System.out.println(like);
	}
	@Test
	public void testDisLike() {
		
		Like like = Like.builder()
				.rno(197L)
				.mid("nsw")
				.build();
		
		dao.disLike(like);
	}
	@Test
	public void testUpdateLike() {
		
		Like like = Like.builder()
				.rno(197L)
				.mid("nsw")
				.build();
		
		dao.updateLike(like);
	}
	@Test
	public void testselectLike() {
		Like like = Like.builder()
				.rno(197L)
				.mid("nsw")
				.build();
		log.info(dao.selectLike(like));
		
		
	}
	
	@Test
	public void testgetLike() {
		Review like = Review.builder()
						.rno(22L)
						.mid("nsw")
						.build();
		log.info(dao.getValue(like));
		
		
	}
	
	
}
