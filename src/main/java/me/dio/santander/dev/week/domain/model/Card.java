package me.dio.santander.dev.week.domain.model;

import java.math.BigDecimal;

public class Card {
    private Long id;
    private String number;
    private BigDecimal limit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
