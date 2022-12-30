package chap_10;

public class _02_AnonymousClass2 {
    public static void main(String[] args) {
        // 추상 클래스를 활용하여 그때그때 만들면서 구현할 수 있음
        HomeMadeBurger momMadeBurger = getMomMadeBurger();
        momMadeBurger.cook();

        HomeMadeBurger broMadeBurger = getBroMadeBurger();
        broMadeBurger.cook();
    }

    private static HomeMadeBurger getBroMadeBurger() {
        return new HomeMadeBurger() {
            @Override
            public void cook() {
                System.out.println("집에서 만드는 동생표 군대리아");
                System.out.println("재료: 빵, 치킨패티, 치즈, 따기잼");
            }
        };
    }

    public static HomeMadeBurger getMomMadeBurger() {
        return new HomeMadeBurger() {
            @Override
            public void cook() {
                System.out.println("집에서 만드는 엄마표 수제 버거");
                System.out.println("재료: 빵, 소고기패티, 해시브라운, 상추, 마요네즈, 피클");
            }
        };
    }
}

abstract class HomeMadeBurger {
    public abstract void cook();
}