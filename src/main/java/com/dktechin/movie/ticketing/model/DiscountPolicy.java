package com.dktechin.movie.ticketing.model;

import java.util.Arrays;
import java.util.List;

/**
 * 영화 상영별 할인 정책 도메인 클래스
 * 상영 정보가 할인 조건에 맞는지 확인후
 * 맞다면 자식 클래스의 getDiscountAmount를 호출하여 할인금액을 계산해 반환한다.
 */
public abstract class DiscountPolicy {

    /** * 영화 할인 정책(조건) 목록 */
    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition... discountConditions) {
        this.conditions = Arrays.asList(discountConditions);
    }

    /**
     * 영화 할인 정책에 맞는지 판단후 할인 금액을 계산하여 반환한다.
     * @param screening 영화 상영 정보
     * @return 영화 관람 할인 금액
     */
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening)) {
                return this.getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    /**
     * 영화 상영 정보를 토대로 할인 금액을 계산해 반환한다.
     * @param screening 영화 상영 정보
     * @return 할인 금액
     */
    abstract Money getDiscountAmount(Screening screening);
}
