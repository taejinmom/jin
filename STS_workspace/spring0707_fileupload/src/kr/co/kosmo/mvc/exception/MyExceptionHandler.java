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
		System.out.println("예외 메세지 : "+e.getMessage());
		
		if(e instanceof UnsatisfiedServletRequestParameterException) {
			m.addAttribute("emsg", "파라미터 값을 올바르게 작성하세요.");
			return "error/paramException";
		}else if(e instanceof MissingServletRequestParameterException) {
			m.addAttribute("emsg", "파라미터 값을 올바르게 작성하세요.2");
			return "error/paramException";			
		}else {
			m.addAttribute("emsg", "예외가 발생합니다.");
			return "error/paramException";
		}
	}
}
