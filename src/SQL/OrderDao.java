package SQL;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Order;

public class OrderDao {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource = "resources/mybatis/config-mybatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void order(Order param) {
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			session.insert("mybatis.OrderMapper.order", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}

	public List<Order> show(String param) {
		List<Order> order = new ArrayList<Order>();
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			order = session.selectList("mybatis.OrderMapper.show", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return order;
	}

	public void cancel(Order param) {
		SqlSession session = null;
		try {
			session = sqlSessionFactory.openSession();
			
			session.delete("mybatis.OrderMapper.cancel", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
}
