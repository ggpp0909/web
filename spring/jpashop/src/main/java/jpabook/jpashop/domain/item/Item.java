package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 관계 매핑이라 전략을 부모클래스에서 잡아줘야 함, JOINED 는 가장 정규화된 스타일, Single Table 은 한 테이블에 다 때려박는 스타일, 여기선 싱글테이블로 할 예정
@DiscriminatorColumn(name = "dtype") // 구분 될 때 book 이면 어떻게 나오는 건지
@Getter @Setter

public abstract class Item { // 추상 클래스로 만든다 (구현체를 만들어서 할 것 이기 때문에)

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // 비즈니스 로직 //
    // 데이터가 있는곳에 비즈니스 로직 만드는게 좋다. 응집력이 좋다.
    // 그래서 엔티티에 직접 넣었음

    /**
     * 재고 증가
     */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    /**
     * 재고 증가
     */
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
