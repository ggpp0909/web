package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") // 싱글 테이블이니까 저장될 때 구분할 수 있어야 함
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;
}
