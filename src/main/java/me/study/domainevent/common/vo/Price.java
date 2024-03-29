package me.study.domainevent.common.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@EqualsAndHashCode(of = "price")
@Getter
@Embeddable
public class Price {
    private final BigDecimal price;

    public Price(BigDecimal price) {
        validate(price);
        this.price = price;
    }

    private void validate(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("가격은 0보다 크거나 같아야 합니다.");
        }
    }

    public Price(int price) {
        this(BigDecimal.valueOf(price));
    }

    public Price() {
        this(BigDecimal.ZERO);
    }
}
