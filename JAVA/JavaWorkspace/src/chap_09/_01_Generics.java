package chap_09;

public class _01_Generics {
    public static void main(String[] args) {
        // 제네릭스
        // 다양한 타입의 객체를 지원하는 클래스나 인터페이스 또는 메소드를 정의하는 방법
        // 제네릭스는 일반 자료형에서는 못써서 Wrapper class 로 해야함, (참고: String 은 Wrapper 클래스는 아님)
        Integer[] iArr = {1, 2, 3, 4, 5};
        Double[] dArr = {1.0, 2.0, 3.0, 4.0, 5.0};
        String[] sArr = {"A", "B", "C", "D", "E"};

        // 자료형만 다르고 똑같음, 여러 메서드 만들어야해서 불편함
        printIntArray(iArr);
        printDoubleArray(dArr);
        printStringArray(sArr);

        System.out.println("--------------");
        // 하나의 메소드로 대처 가능
        printAnyArray(iArr);
        printAnyArray(dArr);
        printAnyArray(sArr);
    }

    // 제네릭스
    // T는 타입을 의미, 다르게 해도 되지만 일반적으론 T로함
    private static <T> void printAnyArray(T[] array) {
        for (T t : array) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    private static void printStringArray(String[] sArr) {
        for (String s : sArr) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void printDoubleArray(Double[] dArr) {
        for (double d : dArr) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    private static void printIntArray(Integer[] iArr) {
        for (int i : iArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
