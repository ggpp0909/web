package chap_01;

public class _05_VariableNaming {
    public static void main(String[] args) {
        // 변수 이름 짓는 법
        // 1. 저장할 값에 어울리는 이름
        // 2. 밑줄(_), 문자(abc), 숫자(123) 사용가능 (공백 사용 불가)
        // 3. 밑줄 또는 문자로 시작 가능
        // 4. 한 단어 또는 2개 이상의 단어의 연속
        // 5. 소문자로 시작, 각 단어의 시작 글자는 대문자 (첫 문자는 제외)
        // 6. 예약어 사용 불가

        // 개인정보 예시
        String nationality = "대한민국";
        String firstName = "영남";
        String lastName = "장";
        String dateOfBirth = "1995-05-27";

        // 절대 변하지 않는 상수는 대문자로
        final String CODE = "KR";
    }
}
