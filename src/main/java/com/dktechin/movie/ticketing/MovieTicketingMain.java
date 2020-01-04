package com.dktechin.movie.ticketing;

import com.dktechin.movie.ticketing.model.AmountDiscountPolicy;
import com.dktechin.movie.ticketing.model.Customer;
import com.dktechin.movie.ticketing.model.Money;
import com.dktechin.movie.ticketing.model.Movie;
import com.dktechin.movie.ticketing.model.NoneDiscountPolicy;
import com.dktechin.movie.ticketing.model.PercentDiscountPolicy;
import com.dktechin.movie.ticketing.model.PeriodCondition;
import com.dktechin.movie.ticketing.model.Reservation;
import com.dktechin.movie.ticketing.model.Screening;
import com.dktechin.movie.ticketing.model.SequenceCondition;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MovieTicketingMain {

    public static void main(String[] args) {
        // 고객 정보
        Customer customer = new Customer();
        // 1회차에 2000원 할인
        Movie aloneHomeMovie = new Movie(
            "나홀로집에",
            Duration.ofMinutes(120),
            Money.wons(12000L),
            new AmountDiscountPolicy(Money.wons(2000L), new SequenceCondition(1))
        );

        // 나홀로집에 1회차 상영정보
        Screening aloneHomeScreening_1 = new Screening(aloneHomeMovie, 1, LocalDateTime.now());
        // 나홀로집에 2회차 상영정보
        Screening aloneHomeScreening_2 = new Screening(aloneHomeMovie, 2, LocalDateTime.now());

        Reservation aloneHomeReserve_1 = aloneHomeScreening_1.reserve(customer, 2);
        System.out.println("aloneHomeReserve_1 :: " + aloneHomeReserve_1); // 20000원

        Reservation aloneHomeReserve_2 = aloneHomeScreening_2.reserve(customer, 2);
        System.out.println("aloneHomeReserve_2 :: " + aloneHomeReserve_2); // 24000원

        // 월요일 오전 7~10시, 저녁 9시~11시 10%할인
        Movie xManMovie = new Movie(
            "XMan",
            Duration.ofMinutes(120),
            Money.wons(12000L),
            new PercentDiscountPolicy(
                10,
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(10, 0)),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(23, 0))
            )
        );

        // 월요일 오전 8시
        LocalDateTime discountDay = LocalDateTime.of(2020, 1, 6, 8, 0);
        // ￿화요일 오전 8시
        LocalDateTime noDiscountDay = LocalDateTime.of(2020, 1, 7, 8, 0);

        Screening discountScreen = new Screening(xManMovie, 1, discountDay);
        Screening noDiscountScreen = new Screening(xManMovie, 1, noDiscountDay);

        Reservation discountReserve = discountScreen.reserve(customer, 2);
        Reservation noDiscountReserve = noDiscountScreen.reserve(customer, 2);

        System.out.println("discountReserve :: " + discountReserve); // 216000원
        System.out.println("noDiscountReserve :: " + noDiscountReserve); // 24000원

        // 할인 정책 없음
        Movie starWarsMovie = new Movie(
            "StarWars",
            Duration.ofMinutes(120),
            Money.wons(12000L),
            new NoneDiscountPolicy()
        );

        Screening starWarsScreening = new Screening(starWarsMovie, 1, LocalDateTime.now());
        Reservation starWarsReserve = starWarsScreening.reserve(customer, 1);

        System.out.println("starWarsReserve :: " + starWarsReserve); // 12000원
    }
}
