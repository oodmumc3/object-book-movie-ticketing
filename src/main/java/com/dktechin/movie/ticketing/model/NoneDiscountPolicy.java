package com.dktechin.movie.ticketing.model;

/**
 * 할인 정책이 없을시 사용
 */
public class NoneDiscountPolicy implements DiscountPolicy {
    /**
     * 할인 정책이 없으므로 할인 금액 0원을 반환한다.
     * @param screening 영화 상영 정보
     * @return 0원 반환
     */
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
