package chap_13;

import java.io.File;

public class _04_Folder {
    public static void main(String[] args) {
        String folderName = "A";
        File folder = new File(folderName);
        folder.mkdir();
        if (folder.exists()) {
            System.out.println("폴더가 존재합니다: " + folder.getAbsolutePath());
        }

        System.out.println("-----");

        folderName = "A/B/C";
        folder = new File(folderName);
        // folder.mkdir();
        folder.mkdirs(); // 이처럼 여러 뎁스의 폴더를 만들때는 이렇게
        if (folder.exists()) {
            System.out.println("폴더가 존재합니다: " + folder.getAbsolutePath());
        } else {
            System.out.println("폴더 생성 실패");
        }
    }
}
