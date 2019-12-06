package SQL;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Shop;
import domain.Toy;

public class ToyDao {

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

	public List<Toy> selectList() {
		List<Toy> toy = new ArrayList<>();
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			toy = session.selectList("mybatis.ToyMapper.selectList");
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return toy;
	}

	public Toy select(Toy param) {
		Toy toy = new Toy();
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			toy = session.selectOne("mybatis.ToyMapper.select", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return toy;
	}

	public void update(Toy param) {
		SqlSession session=null;
		try {
			session = sqlSessionFactory.openSession();
			
			session.update("mybatis.ToyMapper.update", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}
	

}
