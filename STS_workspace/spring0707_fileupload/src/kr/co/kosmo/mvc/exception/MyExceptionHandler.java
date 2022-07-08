package kr.co.kosmo.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String myHandlerException(Model m, Exception e) {
		e.printStackTrace();
		System.out.println("���� �޼��� : "+e.getMessage());
		
		if(e instanceof UnsatisfiedServletRequestParameterException) {
			m.addAttribute("emsg", "�Ķ���� ���� �ùٸ��� �ۼ��ϼ���.");
			return "error/paramException";
		}else if(e instanceof MissingServletRequestParameterException) {
			m.addAttribute("emsg", "�Ķ���� ���� �ùٸ��� �ۼ��ϼ���.2");
			return "error/paramException";			
		}else {
			m.addAttribute("emsg", "���ܰ� �߻��մϴ�.");
			return "error/paramException";
		}
	}
}
