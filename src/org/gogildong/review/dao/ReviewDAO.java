package org.gogildong.review.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.review.domain.Like;
import org.gogildong.review.domain.Review;
import org.gogildong.store.domain.Store;

public class ReviewDAO {

	private static final String NAMESPACE = "review.dao.ReviewMapper";

	public List<Review> getReview(PageInfo pageInfo) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getReview", pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public Store getStore(Long rno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getStore", rno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getTotal(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getTotal", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public void insert(Review review) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", review);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRcount(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".updateRcount", sno);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insertLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".updateLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void disLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".disLike", like);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Like selectLike(Like like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".selectlike", like);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public int getValue(Review like) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getValue", like);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void deleteReview(Long rno) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.delete(NAMESPACE + ".delete", rno);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Review getOne(Long rno) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			return session.selectOne(NAMESPACE+".getOne" , rno);
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
public void update(Review review) {
		
		try(SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			
			session.update(NAMESPACE+".update" , review);
			
			session.commit();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
