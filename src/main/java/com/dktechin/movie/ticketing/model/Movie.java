package com.dktechin.movie.ticketing.model;

import java.time.Duration;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 영화 관련 정보 도메인 클래스
 */
@RequiredArgsConstructor
public class Movie {
    /** * 영화 제목 */
    private final String title;
    /** * 상영 시간 */
    private final Duration runningTime;
    /** * 영화 관람 금액 */
    @Getter private final Money fee;
    /** * 영화 할인 정책 정보 */
    private final DiscountPolicy discountPolicy;

    /**
     * 상영 정보에 따른 할인 정책을 고려해 영화 관람 가격을 계산후 반환한다.
     * @param screening 영화 상영 정보
     * @return
     */
    public Money calculateMovieFee(Screening screening) {
        // 할인 정책이 없는 특수한 상황시 기존 금액을 반환한다.
        if (this.discountPolicy == null) {
            return this.fee;
        }

        return this.fee.minus(this.discountPolicy.calculateDiscountAmount(screening));
    }
}
