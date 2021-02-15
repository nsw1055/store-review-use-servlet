package org.gogildong.common.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import lombok.Getter;

@Getter
public enum MyBatisMaker {
	
	INSTANCE;
	
	private SqlSessionFactory factory;
	
	MyBatisMaker(){
		try {
			
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
