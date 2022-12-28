package chap_04;

public class _03_ElseIf {
    public static void main(String[] args) {
        // 조건문 else if
        // 한라봉 에이드가 있으면 + 1
        // 또는 망고주스가 있으면 + 1
        // 또는 아아 + 1

        boolean hallabongAde = true; //한라봉에이드
        boolean mangoJuice = true; // 망고 주스

        if (hallabongAde) {
            System.out.println("한라봉 에이드 + 1");
        } else if (mangoJuice) {
            System.out.println("망고주스 + 1");
        } else  {
            System.out.println("아아 + 1");
        }

    }
}
