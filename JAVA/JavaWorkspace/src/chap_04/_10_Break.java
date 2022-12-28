package chap_04;

public class _10_Break {
    public static void main(String[] args) {
        // break

        // for 문
        int max = 20;
        for (int i = 0; i <= 50; i++) {
            System.out.println(i);
            if (i == max) break;
        }

        // while 문
        int index = 1;
        while (index <= 50) {
            System.out.println(index);
            if (index == max) break;
            index++;
        }
    }
}
