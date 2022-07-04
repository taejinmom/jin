package ex3_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//Advice Ŭ������ ���� �ض�
//MethodInvocation invocation Ÿ���� �޼����� ȣ�� ������ ������ �ִ� ��ü�� ���ڷ� ���Թ���
public class Ex1_MessageAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
			System.out.println("���� �� ���� �����Ͻ� ������ ���� ��");

			Object rev = invocation.proceed();
			if(rev != null) {
				System.out.println("REV : " + rev);
				
			}
			
			
			
			System.out.println("���� ���� �����Ͻ� ������ ���� ��");
			return rev;
	}
	
}
/*
 * ����ǥ����(*:����Ÿ�� ex1.:��Ű����� DaoImple.:Ŭ������ first:�޼����(..):���ڰ� .. ���ڰ� ���ų� �ϳ��̻��ΰ��� �ǹ�
 * execution( * ex1.DaoImple.first(..))
 * ����Ÿ�� ���� :
 * => * : ��� ����Ÿ�� ��� ( �⺻ )
 * => void : ����Ÿ���� void�� �޼��� ����
 * => !void : ����Ÿ���� void�� �ƴ� �޼��� ����
 * 
 * ��Ű�� ����
 * =>com.kosmo.mvc : ��Ȯ�ϰ� com.kosmo.mvc ��Ű���� ����
 * =>com.kosmo.mvc.. :com.kosmo.mvc�� �����ϴ� ��Ű���� ���� 
 * =>com.kosmo.mvc..imple : com.kosmo.mvc�� �����ϸ鼭 imple�� ������ ��Ű�� ����
 * 
 * Ŭ�������� :*,+ 
 * =>DaoImple : ��Ȯ�ϰ� DaoImple Ŭ������ ����
 * =>*Imple : Ŭ�����̸��� Imple�� ������ Ŭ������ ����
 * =>Dao* : Ŭ�����̸��� Dao�� �����ϴ� Ŭ������ ����
 * =>DaoImple+ : �ش� Ŭ�����κ��� �Ļ��� ��� �ڽ�Ŭ���� ����
 * 
 * �޼������� : *, �Ű����� �ȿ���(..)
 * =>first() : first() �޼��常 ����
 * =>first(..) : ���ڰ��� ���ų� �ϳ� �̻��� �޼��� ����
 * =>*st(..) : st�γ����鼭 �Ű������� ���ų� �ϳ��̻�
 * =>first*(..) : first�� �����ϸ鼭 �Ű������� ���ų� �ϳ��̻�
 * =>first(*) : �ݵ�� �Ѱ��� �Ű������� ������ �޼��弱��
 * =>first(kosmo.dto.MemberDTO) : DTO�� �Ű������� ����
 */