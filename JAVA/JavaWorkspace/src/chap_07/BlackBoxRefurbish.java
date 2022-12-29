package chap_07;

// public class 로 정의하는 경우 반드시 자바 파일 이름과 동일해야 함.
public class BlackBoxRefurbish {
    public String modelName; // 모델 명
    String resolution; // 해상도
    // private 붙였으므로 인스턴스에서 직접 접근 불가
    private int price; // 가격
    protected String color; // 색

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getResolution() {
        if (resolution == null || resolution.isEmpty()) {
            return "판매자에게 문의하세요.";
        }
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 100000) {
            this.price = 100000;
        } else {
            this.price = price;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
