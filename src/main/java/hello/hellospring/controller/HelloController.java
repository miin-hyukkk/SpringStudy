package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello2")//애는 html이름이 아니야  매핑할때 해주는거야 localhost:8080/hello2
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }
    @GetMapping("hello-mvv")
    public String helloMvc(@RequestParam(name="name") String name, Model model){
        //리퀘스트=true 라는 파라미터가 기본으로 되어있어서 도메인 입력시 ?name=뭐뭐를 입력해주어야 에러가 발생하지 않는다.
        model.addAttribute("name",name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody//html에 나오는 바디가 아니라 https에 header부와 body부가 있는데 그 body부에 저 return 내용을 직접 넣어주겠다는거임
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring" 요청한게 그대로 내려감 view 이런게 없어  html을 겪지 않는거지
    }

    //json방식
    //최근에는 거의 json방식으로 통일됨
    @GetMapping("hello-api")
    @ResponseBody
    //Hello라는 객체를 하나 생성
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    //스테틱으로 만들면 클래스안에서 또 이렇게 클래스를 사용 가능
    static class Hello {
        //
        private String name;
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}

