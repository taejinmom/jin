package ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*�ʼ����
 * �ڵ����� ���� �����ִ� ������ API
 * bean�� bean�� �������踦 �ڵ����� �����Ѵ�.
 * bytype,byname�� ���� ���� ����
 * byname : property��bean �̸��� �������
 * bytype : �̸��� ���� bean�� ã�°��̾ƴ϶� Ÿ���� ���� ���� ã�ƿ´�. ->class
 * �̶� �ߺ��� Ÿ���� ������ ���ܰ� �߻��Ѵ� - > qualifier ���ľ �������ָ� ���� X
 * ������ �޼��� ������� �����ٰ� �����ؼ� ���
 * ���������� �������ִ� ������̼� ����� ����
 * @Autowired -> springfreamwork = AOP��� ����
 * @Resource -> javax.annotation.Resource
 * Inject -> javax.inject.Inject
 * autowired->����� �� ��Ģ
 * context->�ݵ�� xml�� ���� �ؾ� �Ѵ�
 * ����ʵ忡 @AutoWired�� �����ϸ�Setter�� �ʿ����
 * */
public class Ex1_AutoWired {
	@Autowired
	@Qualifier("kosmo112")
	private String msg;
	
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
	public String getMessage() { // ȣ���� �޼��� 
		StringBuffer sb= new StringBuffer();
		sb.append("<p style='color:red'>");
		sb.append(msg);
		sb.append("</p>");
		return sb.toString();
	}

	
}
