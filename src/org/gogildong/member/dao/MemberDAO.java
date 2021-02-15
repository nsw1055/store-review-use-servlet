package org.gogildong.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.gogildong.common.dao.MyBatisMaker;
import org.gogildong.member.domain.Member;

public class MemberDAO {

	private static final String NAMESPACE = "org.gogildong.member.dao.MemberMapper";

	public String getMember(Long sno) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			return session.selectOne(NAMESPACE + ".getMember", sno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Member getMemberInfo(String mid) {
		
		try (SqlSession session = MyBatisMaker.INSTANCE.getFactory().openSession()) {
			return session.selectOne(NAMESPACE + ".getMemberInfo",mid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
