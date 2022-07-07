package kr.co.kosmo.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//@Controller -> DispathcerServlet 요청하기 위한 모델로 등록
@Controller
public class DefaultController {
    //HandlerMapping : 요청을 분석하고 해당 모델을 실행
    @RequestMapping(value = {"/","/main"})
    public String defaultIndex() {
        return "main/index"; // ModelAndView
    }
}