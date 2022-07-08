package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//@Controller -> DispathcerServlet ��û�ϱ� ���� �𵨷� ���
@Controller
public class DefaultController {
    //HandlerMapping : ��û�� �м��ϰ� �ش� ���� ����
    @RequestMapping(value = {"/","/main"})
    public String defaultIndex() {
        return "main/index"; // ModelAndView
    }
}