package chap_06;

public class _04_ParameterAndReturn {
    public static int getPower(int number) {
        int res = number * number;
        return res;
    }

    public static int getPowerByExp(int number, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        int retVal = getPower(2);
        System.out.println(retVal);

        retVal = getPowerByExp(2, 3);
        System.out.println(retVal);
    }
}
