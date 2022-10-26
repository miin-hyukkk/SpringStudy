package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")// 이 슬래쉬는 localhost8080딱 들어오면 얘가 호출돼 얘가 홈(/)이니까

    public String home(){
        return "home";
    }
}
