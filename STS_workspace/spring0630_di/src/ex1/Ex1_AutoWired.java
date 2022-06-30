package ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*필수기능
 * 자동으로 빈을 묶어주는 스프링 API
 * bean과 bean의 의존관계를 자동으로 설정한다.
 * bytype,byname에 대한 개념 이해
 * byname : property와bean 이름이 같을경우
 * bytype : 이름이 같은 bean을 찾는것이아니라 타입이 같은 빈을 찾아온다. ->class
 * 이때 중복된 타입이 있으면 예외가 발생한다 - > qualifier 수식어를 지정해주면 예외 X
 * 생성자 메서드 멤버변수 위에다가 정의해서 사용
 * 스프링에서 제공해주는 어노테이션 상당히 많음
 * @Autowired -> springfreamwork = AOP기술 적용
 * @Resource -> javax.annotation.Resource
 * Inject -> javax.inject.Inject
 * autowired->사용할 때 규칙
 * context->반드시 xml에 정의 해야 한다
 * 멤버필드에 @AutoWired를 선언하면Setter가 필요없다
 * */
public class Ex1_AutoWired {
	@Autowired
	@Qualifier("kosmo112")
	private String msg;
	
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
	public String getMessage() { // 호출할 메서드 
		StringBuffer sb= new StringBuffer();
		sb.append("<p style='color:red'>");
		sb.append(msg);
		sb.append("</p>");
		return sb.toString();
	}

	
}
