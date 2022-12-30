package chap_09;

// ArrayList 를 이용하여 학생별 프로그래밍 언어 자격증 취득 정보를 관리하고 자바 자격증을 보유한 학생 이름을 출력하시오.
// 조건
// 학생 이름 및 자격증 취득 정보를 위한 Student 클래스 생성
// 학생 1인당 보유 자격증은 1개로 제한
// 모든 클래스는 하나의 파일에 정의

// 학생 이름 및 자격증 취득 정보
// 유재석: 파이썬
// 박명수: 자바
// 김종국: 자바
// 조세호: C
// 서장훈: 파이썬

import java.util.ArrayList;

public class _Quiz_09 {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("유재석", "파이썬"));
        arr.add(new Student("박명수", "자바"));
        arr.add(new Student("김종국", "자바"));
        arr.add(new Student("조세호", "C"));
        arr.add(new Student("서장훈", "파이썬"));

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).license == "자바") {
                System.out.println(arr.get(i).name);
            }
        }
    }
}

class Student {
    String name;
    String license;

    public Student(String name, String license) {
        this.name = name;
        this.license = license;
    }
}
