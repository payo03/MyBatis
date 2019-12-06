package SQL;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Customer;

public class CustomerDao {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		try {
			String resource="resources/mybatis/config-mybatis.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Customer register(Customer param) {
		Customer customer = new Customer();
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			session.insert("mybatis.CustomerMapper.register", param);
			
			session.commit();
		}catch(Exception e ) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return customer;
	}


	public Customer login(Customer param) {
		Customer customer = new Customer();
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			customer = session.selectOne("mybatis.CustomerMapper.login", param);
			
			session.commit();
		}catch(Exception e ) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return customer;
	}
}
