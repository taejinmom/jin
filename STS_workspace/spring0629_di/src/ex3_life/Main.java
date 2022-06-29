package ex3_life;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
public static void main(String[] args) {
	/*최상위 인터페이스, 존재의 이유 - 사용안함(?)
	1.가장 기본적인 스프링 컨테이너이다. getBean할때 생성이 된다.원시적인 기능
	*/
	BeanFactory ctx = new XmlBeanFactory(new FileSystemResource("src/ex3_life/life.xml"));
	/*
	 2.getBean을 했을때 비로소 스프링 컨테이너를 생성한다.
	*/
	Lifeinter inter = ctx.getBean("life",Lifeinter.class);
}
}
