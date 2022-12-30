package chap_10.converter;

// 이 어노테이션을 붙여서 이 인터페이스는 함수형 인터페이스로 쓸거라는걸 컴파일러에게 알려줌
// 두개의 함수를 작성시 오류로 알려줌
@FunctionalInterface
public interface Convertible {
    void convert(int USD);
}
