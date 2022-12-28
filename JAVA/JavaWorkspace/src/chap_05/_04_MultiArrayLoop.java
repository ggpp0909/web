package chap_05;

public class _04_MultiArrayLoop {
    public static void main(String[] args) {
        // 다차원 배열 순회
        String[][] seats = new String[][] {
                {"A1", "A2", "A3", "A4", "A5"},
                {"B1", "B2", "B3", "B4", "B5"},
                {"C1", "C2", "C3", "C4", "C5"}
        };

        for (int i = 0; i < 3; i++) { // 행
            for (int j = 0; j < 5; j++) { // 열
                System.out.println(seats[i][j]);
            }
        }

        // length 이용
        for (int i = 0; i < seats.length; i++) { // 행
            for (int j = 0; j < seats[i].length; j++) { // 열
                System.out.println(seats[i][j]);
            }
        }

        System.out.println("------------------");
        // 세로크리 10 가로크리 15 해당하는 영화관 좌석정보
        String[][] seats3 = new String[10][15];
        String[] eng = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for (int i = 0; i < seats3.length; i++) {
            for (int j = 0; j < seats3[i].length; j++) {
                seats3[i][j] = eng[i] + (j + 1);
                System.out.println(seats3[i][j]);
            }
        }
    }
}
