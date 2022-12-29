package chap_09.coffee;

public class CoffeeByName {
    public Object name; // Integer, Double 등 모두 가능, Object 는 모두를 상속하니까

    public CoffeeByName(Object name) {
        this.name = name;
    }

    public void ready() {
        System.out.println("커피 준비 완료 : " + name);
    }
}
