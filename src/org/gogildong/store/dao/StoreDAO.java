package org.gogildong.store.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.common.util.PageInfo;
import org.gogildong.store.domain.Store;

public class StoreDAO {

	private static final String NAMESPACE = "store.dao.StoreMapper";

	public List<Store> getAll(PageInfo pageInfo) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectList(NAMESPACE + ".getAll", pageInfo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Store getOne(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getOne", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Store store) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insert", store);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Long sno) {
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			// tbl_review 삭제
			session.delete(NAMESPACE + ".deleteReview", sno);

			// tbl_store 삭제
			session.delete(NAMESPACE + ".delete", sno);

			session.commit();
		} catch (Exception e) {
			// session.rollback();
			e.printStackTrace();
		}
	}

	public void update(Store store) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.update(NAMESPACE + ".update", store);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getTotal() {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getTotal");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getRcount(Long sno) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			return session.selectOne(NAMESPACE + ".getRcount", sno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public void insertRcount(int rcount) {

		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {

			session.insert(NAMESPACE + ".insertRcount", rcount);

			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
