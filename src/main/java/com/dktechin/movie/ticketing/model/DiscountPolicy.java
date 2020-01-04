package com.dktechin.movie.ticketing.model;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
