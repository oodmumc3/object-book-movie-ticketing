package com.dktechin.movie.ticketing.model;

/**
 * 영화 할인 조건 정보 도메인 클래스
 */
public interface DiscountCondition {

    /**
     * 영화 상영 정보를 참고로 영화 할인 조건에 부합하는지 판단하여 반환한다.
     * @param screening 영화 상영 정보
     * @return 할인조건 부합여부
     */
    boolean isSatisfiedBy(Screening screening);
}
