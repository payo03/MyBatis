package SQL;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.Shop;

public class ShopDao {

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

	public boolean check(int shopNo) {
		Shop shop = new Shop();
		boolean confirm = true;	//shopNo에 해당하는 행이 없으면 T
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			
			shop = session.selectOne("org.mybatis.persistence.ShopMapper.selectNo", shopNo);
			
			session.commit();
			if(shop!=null) {	//shopNo에 해당하는 행이 있으면 F
				confirm = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return confirm;	//shopNo에 해당하는 행이 없으면 T
	}

	public void register(Shop param) {
		System.out.println("Auto-Increment사용");
		SqlSession session = null;
		
		try {
			session = sqlSessionFactory.openSession();
			
			session.insert("mybatis.ShopMapper.register", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
	}

	public List<Shop> shopList(Shop param) {
		SqlSession session = null;
		List<Shop> shop = new ArrayList<Shop>();
		try {
			session = sqlSessionFactory.openSession();
			
			shop = session.selectList("mybatis.ShopMapper.shopList", param);
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return shop;
	}
	
}
