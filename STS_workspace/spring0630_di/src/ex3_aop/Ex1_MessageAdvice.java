package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Advice 클래스를 정의 해땅
//MethodInvocation invocation 타겟의 메서드의 호출 정보를 가지고 있는 객체를 인자로 주입받음
public class Ex1_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("선행 될 공통 비지니스 로직이 수행 됨");

			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
				
			}
			
			
			
			System.out.println("후행 공통 비지니스 로직이 수행 됨");
			return rev;
	}
	
}
/*
 * 정규표현식(*:리턴타입 ex1.:패키지경로 DaoImple.:클래스명 first:메서드명(..):인자값 .. 인자가 없거나 하나이상인것을 의미
 * execution( * ex1.DaoImple.first(..))
 * 리턴타입 지정 :
 * => * : 모든 리턴타입 허용 ( 기본 )
 * => void : 리턴타입이 void인 메서드 선택
 * => !void : 리턴타입이 void가 아닌 메서드 선택
 * 
 * 패키지 지정
 * =>com.kosmo.mvc : 정확하게 com.kosmo.mvc 패키지만 선택
 * =>com.kosmo.mvc.. :com.kosmo.mvc로 시작하는 패키지를 선택 
 * =>com.kosmo.mvc..imple : com.kosmo.mvc로 시작하면서 imple로 끝나는 패키지 선택
 * 
 * 클래스지정 :*,+ 
 * =>DaoImple : 정확하게 DaoImple 클래스만 선택
 * =>*Imple : 클래스이름이 Imple로 끝나는 클래스만 선택
 * =>Dao* : 클래스이름이 Dao로 시작하는 클래스만 선택
 * =>DaoImple+ : 해당 클래스로부터 파생된 모든 자식클래스 선택
 * 
 * 메서드지정 : *, 매개변수 안에는(..)
 * =>first() : first() 메서드만 선택
 * =>first(..) : 인자값이 없거나 하나 이상인 메서드 선택
 * =>*st(..) : st로끝나면서 매개변수가 없거나 하나이상
 * =>first*(..) : first로 시작하면서 매개변수가 없거나 하나이상
 * =>first(*) : 반드시 한개의 매개변수를 가지는 메서드선택
 * =>first(kosmo.dto.MemberDTO) : DTO를 매개변수로 가짐
 */