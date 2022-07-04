package factory;
// myBatis의 환경 파일을 읽어와서 SqlSession객체를 관리하는
// SqlSessionFactory를 생성 하고 반환 

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("config/config.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
