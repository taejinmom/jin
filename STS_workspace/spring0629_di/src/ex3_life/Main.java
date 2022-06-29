package ex3_life;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
public static void main(String[] args) {
	/*�ֻ��� �������̽�, ������ ���� - ������(?)
	1.���� �⺻���� ������ �����̳��̴�. getBean�Ҷ� ������ �ȴ�.�������� ���
	*/
	BeanFactory ctx = new XmlBeanFactory(new FileSystemResource("src/ex3_life/life.xml"));
	/*
	 2.getBean�� ������ ��μ� ������ �����̳ʸ� �����Ѵ�.
	*/
	Lifeinter inter = ctx.getBean("life",Lifeinter.class);
}
}
