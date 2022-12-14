package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //이 친구는 자바 직접연결할때도 그대로둠
//이 컨트롤러라는 에노테이션을 보고 스프링이 뜰때 이 해당 컨트롤러를 객체를 스플릿해서 들고 있음
// 이걸 스프링 컨테이너에서 스프링 빈이 관리된다라고 함
public class MemberController {

    private final MemberService memberService;

    //스프링컨테이너에 딱 하나만 등록을 하고 사용
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //멤버컨트롤러는 어차피 스프링 콘테이너가 뜰때 생성을 해준다고 했잖아
    //그러면 저기 컨스트럭터 생성자를 호출을 하잖아
    //생성자에 Autowired라고 되어있으면 이 memberSercive를 스프링이 컨테이너에 있는 memberSercive를 가져다가 연결을 딱 시켜줌
    @GetMapping("members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
        //home화면으로 보내버림
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}



