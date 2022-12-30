package chap_11;

public class _02_Catch {
    public static void main(String[] args) {
        // Exception 은 모든 오류의 조상 격
        // 원할경우 특정 오류만 골라잡을 수 있음 Ex. ArithmeticException
        // 마치 switch 문 처럼 작동
        try {
            System.out.println(3 / 0);

            int[] arr = new int[3];
            arr[5] = 100;
//        } catch (ArithmeticException e) {
//            System.out.println("뭔가 잘못 계산을 했네요");
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) { // 이런식으로 묶기 가능
                System.out.println("뭔가 잘못 됐어요");
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("인덱스를 잘못 설정했어요");
        } catch (ClassCastException e) {
            System.out.println("잘못된 형 변환");
        } catch (Exception e) {
            System.out.println("문제발생! -> " + e);
            System.out.println("그 외에 에러는 모두 여기서 처리가 돼요.");
            e.printStackTrace();
        }

        System.out.println("프로그램 정상 종료");
    }
}
