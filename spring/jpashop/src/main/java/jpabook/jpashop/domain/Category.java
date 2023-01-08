package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany // 다대다는 사용하지말기, 중간테이블을 만들어서 일대 다, 다대 일로 풀어서 사용하기, 여기서는 예제용으로 사용
    @JoinTable(name = "category_item",
        joinColumns = @JoinColumn(name = "category_id"),  // 중간 테이블 그림에 들어갈 것
            inverseJoinColumns = @JoinColumn(name = "item_id") // 반대편에서 들어갈 것
    ) // 얘는 조인컬럼이 아닌 조인테이블
    private List<Item> items = new ArrayList<>();

    // 계층 구조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    // == 연관관계 편의 메서드 == //
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
