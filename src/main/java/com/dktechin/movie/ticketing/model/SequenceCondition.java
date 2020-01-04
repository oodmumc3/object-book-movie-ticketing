package com.dktechin.movie.ticketing.model;

public class SequenceCondition implements DiscountCondition {

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return false;
    }
}
