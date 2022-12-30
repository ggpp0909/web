package chap_10.converter;

public class KRWConverter implements Convertible{
    @Override
    public void convert(int USD) {
        System.out.println(USD + "달러 = " + (USD * 1400) + " 원");
    }
}
