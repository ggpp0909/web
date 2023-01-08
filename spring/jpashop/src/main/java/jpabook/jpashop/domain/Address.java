package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable // jpa 내장 타입이기 때문에, 어딘가에 내장이 될 수 있다
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
