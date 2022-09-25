package hello.hellospring.domain;

public class Member {

    private  Long id;//고객 아이디가아니라 시스템이 정한 아이디
    private String name;//고객이 회원가입할때 적는 거임

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
