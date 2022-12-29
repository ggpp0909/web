package chap_08.reporter;

// 인터페이스는 implements 가져옴
public class NormalReporter implements Reportable {
    @Override
    public void report() {
        System.out.println("일반 화재 신고를 진행합니다.");
    }
}
