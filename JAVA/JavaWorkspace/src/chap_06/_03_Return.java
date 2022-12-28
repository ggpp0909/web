package chap_06;

public class _03_Return {
    // 호텔 전화번호
    public static String getPhoneNumber() {
        String num = "02-1234-5678";
        return num;
    }

    // 호텔 주소
    public static String getAddress() {
        return "서울시 어딘가";
    }


    public static void main(String[] args) {
        String contactNumber = getPhoneNumber();
        String address = getAddress();
        System.out.println(contactNumber);
        System.out.println(address);
    }
}
