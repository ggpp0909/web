package chap_09.coffee;

import chap_09.user.User;

// 어떤 형태의 T를 써도 상관없는데 반드시 User 클래스를 상속하는 T를 써야 한다.
// 즉 User, VIPUser 만 들어옴, 제네릭에서 타입을 제한하는 방법
public class CoffeeByUser <T extends User> {
    public T user;

    public CoffeeByUser(T user) {
        this.user = user;
    }

    public void ready() {
        System.out.println("커피 준비 완료: " + user.name);
        user.addPoint();
    }
}
