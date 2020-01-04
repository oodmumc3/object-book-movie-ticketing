package com.dktechin.movie.ticketing.model;

import lombok.RequiredArgsConstructor;

/**
 * 예약 정보 도메인 클래스
 */
@RequiredArgsConstructor
public class Reservation {
    /** * 예약 고객정보 */
    private final Customer customer;
    /** * 예약 상영 정보 */
    private final Screening screening;
    /** * 예약 금액 */
    private final Money fee;
    /** * 예약 인원 수 */
    private final int audienceCount;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Reservation{");
        sb.append("fee=").append(fee);
        sb.append(", audienceCount=").append(audienceCount);
        sb.append('}');
        return sb.toString();
    }
}
