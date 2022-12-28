package chap_07;

public class _04_Method {
    public static void main(String[] args) {
        BlackBox b1 = new BlackBox();
        b1.modelName = "까망이";

        b1.autoReport(); // 지원 안됨
        BlackBox.canAutoReport = true;
        b1.autoReport(); // 지원 됨

        // 전달값 있는 메소드
        b1.insertMemoryCard(256);

        // 전달값, 반환값 있는 메소드

        // 일반 영상: 1
        // 이벤트 영상: 2
        int fileCount = b1.getVideoFileCount(1);
        System.out.println(fileCount);

        fileCount = b1.getVideoFileCount(2);
        System.out.println(fileCount);
    }
}
