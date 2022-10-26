package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//@Service //컴포넌트 스캔방법
//스프링에 딱 뜰때 이거보고 서비스네 하고 오토와이어드 보고 너는 메모리멤버리포지터리가 필요하구나 하고 컨테이너에 있는 메모리멤버리포지터리를 넣어줌
public class MemberService {

    private final MemberRepository memberRepository;
//    @Autowired //컴포넌트 스캔방법
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        validateDuplicateMember(member);// 증복회원 검색

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }

    //전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId){
        return  memberRepository.findById(memberId);
    }
}
