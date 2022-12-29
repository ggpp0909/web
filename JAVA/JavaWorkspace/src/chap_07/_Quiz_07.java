package chap_07;

// 클래스를 이용하여 햄버거를 자동으로 만드는 프로그램 작성
// 조건
// 햄버거의 종류는 햄버거, 치즈버거, 새우버거 3가지
// 각 버거는 각각의 클래스로 생성
// 버거 이름을 담기 위한 name 변수 정의
// 재료 정보를 표시하는 cook() 메소드 정의
// 공통 부분은 상송 및 메소드 오버라이딩으로 처리
// 모든 클래스는 하나의 파일에 정의
// 각 버거의 재료정보
// 햄버거: 양상추 패티 피클
// 치즈버거: 양상추 패티 피클 치즈
// 새우버거 양상추 패티 피클 새우

public class _Quiz_07 {
    public static void main(String[] args) {
        HamBurger[] hamBurgers = new HamBurger[3];
        hamBurgers[0] = new HamBurger();
        hamBurgers[1] = new CheeseBurger();
        hamBurgers[2] = new ShrimpBurger();

        for (HamBurger hamBurger: hamBurgers) {
            hamBurger.cook();
        }
    }
}

class HamBurger {
    public String name;

    public HamBurger() {
        name = "햄버거";
    }

    public HamBurger(String name) {
        this.name = name;
    }

    public void cook() {
        System.out.println(this.name + "를 만듭니다.");
        System.out.println("빵 사이에 들어가는 재료는?");
        System.out.println("> 양상추");
        System.out.println("+ 패티");
        System.out.println("+ 피클");
    }
}

class CheeseBurger extends HamBurger {
    public CheeseBurger() {
        super("치즈버거");
    }

    @Override
    public void cook() {
        super.cook();
        System.out.println("+ 치즈");
    }
}

class ShrimpBurger extends HamBurger {
    public ShrimpBurger() {
        super("todn");
    }

    @Override
    public void cook() {
        super.cook();
        System.out.println("+ 새우");
    }
}