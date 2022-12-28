package chap_03;

// 주민등록 번호에서 생년원일 및 성별까지만 출력하는 프로그램을 작성
// 주민등록번호는 13자리 숫자
// 앞 6자리는 생년월일, 뒷 7자리중 첫숫자는 성별정보
// 입력데이터는 -을 포함한 14자리 문자열 형태


public class _Quiz_03 {
    public static void main(String[] args) {
        String id = "123456-7891234";
        System.out.println(id.substring(0, 8));
        System.out.println(id.substring(0, id.indexOf("-") + 2));

    }
}
