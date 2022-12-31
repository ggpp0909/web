package chap_13;

import java.io.File;

public class _07_DeleteFile {
    public static void main(String[] args) {
        File file = new File("goodjob.txt");
        // 삭제 후 삭제되었는지를 불리안으로 리턴해줌
        if (file.exists()){
            if (file.delete()) {
                System.out.println("파일 삭제 성공: " + file.getName());
            } else {
                System.out.println("파일 삭제 실패: " + file.getName());
            }
        }

//        File folder = new File("A"); // 하위에 폴더가 있을 경우 삭제 안됨, 하위부터 순차적으로 지워야함
//        File folder = new File("A/B/C"); // C만 삭제됨
        File folder = new File("A");
        if (folder.exists()) {
            if (folder.delete()) {
                System.out.println("폴더 삭제 성공: " + folder.getAbsolutePath());
            } else {
                System.out.println("폴더 삭제 실패: " + folder.getAbsolutePath());
            }
        }

        if (deleteFolder(folder)) {
            System.out.println("*폴더 삭제 성공: " + folder.getAbsolutePath());
        } else {
            System.out.println("*폴더 삭제 실패: " + folder.getAbsolutePath());
        }
    }

    // 하위 폴더까지 모두 삭제시키는 메소드 구현
    // 재귀적 완전탐색으로 모두 삭제함
    public static boolean deleteFolder(File folder) {
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                deleteFolder(file);
            }
        }
        System.out.println("폴더 삭제 대상: " + folder.getAbsolutePath());
        return folder.delete();
    }
}
