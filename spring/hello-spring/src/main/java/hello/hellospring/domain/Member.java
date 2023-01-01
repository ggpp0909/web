package hello.hellospring.domain;

public class Member {

    private Long id; // 고객 아이디가 아닌 데이터 구분용 아이디
    private String name; // 고객 이름

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
