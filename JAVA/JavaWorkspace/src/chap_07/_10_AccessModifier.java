package chap_07;

public class _10_AccessModifier {
    public static void main(String[] args) {
        // 캡슐화 (Encapsulation)
        // 필요한 것들, 연관된 것들 끼리만 하나의 캡슐에 넣는다는 것을 의미
        // 블랙박스클래스에는 블랙박스에 관련된 것만 넣기

        // 정보 은닉 (information hiding)
        // 정보를 숨김, 블랙박스 가격을 마음대로 바꾸던가 그런것을 막는것
        // 객체내의 변수나 메서드의 직접 접근을 막고 허용하는 방법으로만 접근할 수 있도록 막아주는
        // 접근 제어자, public, private 등

        // 접근 제어자
        // private : 해당 클래스 내에서만 접근 가능
        // public : 모든 클래스에서 접근 가능
        // default : (아무것도 적지 않았을 때) 같은 패키지 내에서만 접근 가능
        // protected : 같은 패키지 내에서 접근가능, 다른 패키지인 경우 자식클래스에서 접근 가능

        BlackBoxRefurbish b1 = new BlackBoxRefurbish();
        b1.modelName = "까망이";
        // b1.resolution = "FHD";
        b1.setPrice(200000);
        b1.color = "블랙";

        // 할인 행사
        b1.setPrice(-5000);
        System.out.println("가격 : " + b1.getPrice() + "원");

        // 고객 문의
        System.out.println("해상도 : " + b1.resolution);

        BlackBoxRefurbish b2 = new BlackBoxRefurbish();
        b2.setModelName("하양이");
        b2.setPrice(-5000);
        b2.setColor("화이트");

        System.out.println(b2.getPrice());
        System.out.println(b2.getResolution());

    }
}
