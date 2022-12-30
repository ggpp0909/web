package chap_11;

public class _01_TryCatch {
    public static void main(String[] args) {
        // 예외 처리

        // 오류 : 컴파일 오류, 런타임 오류
        // 컴파일 오류: 코드에 문제가 있어 실행 조차 안됨
        // int i = "문자열";
        // 런타임 오류: 컴파일은 되지만 실행 과정중 문제 발생
        // int[] arr = new int[3];
        // arr[5] = 100;

        // 런타임 오류도 두가지가 있음
        // 에러, 예외
        // 에러 error 는 코드로 수습 불가, 예외 exception 은 코드로 수습 가능

        // try 문 내에서 오류 발생 시 catch 문 실행
        try{
//            System.out.println(3 / 0);
             int[] arr = new int[3];
             arr[5] = 100;
        } catch (Exception e) {
            System.out.println("문제발생! -> " + e);
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }
}
