package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DisCountPolicy {

    private  int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int Price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
