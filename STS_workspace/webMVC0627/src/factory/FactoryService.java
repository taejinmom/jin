package factory;
// myBatis�� ȯ�� ������ �о�ͼ� SqlSession��ü�� �����ϴ�
// SqlSessionFactory�� ���� �ϰ� ��ȯ 

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
