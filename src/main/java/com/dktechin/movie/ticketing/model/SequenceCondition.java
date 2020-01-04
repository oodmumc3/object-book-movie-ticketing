package com.dktechin.movie.ticketing.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SequenceCondition implements DiscountCondition {

    /** * 영화 관람금액을 할인해줄 회차 */
    private final int sequence;

    /**
     * 영화 상영정보의 회차를 가지고 할인 여부를 판단한다.
     */
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(this.sequence);
    }
}
