package advice;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;

public class SecurityAdvice {
	int count;
	
	@Before("execution(* exam.LoginTest.*(..))")
	public void beforeMethod() {
		Scanner sc = new Scanner(System.in);
		t: while (true) {
			String pwd;
			System.out.println("비밀번호 입력 : ");
			pwd = sc.nextLine();
			count++;
			if (!pwd.equals("123")) {
				if (count == 1) {
					System.out.println("땡");
				} else if (count == 2) {
					System.out.println("땡2");
				} else {
					System.out.println("접근제한");
					System.exit(0);
					sc.close();
				}
			} else {
				sc.close();
				break t;
			}

		}
	}
}
