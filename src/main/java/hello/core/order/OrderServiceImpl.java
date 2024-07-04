package hello.core.order;

import hello.core.discount.DisCountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    /*
    인터페이스에만 의존하도록 설계와 코드를 변경
    구현체가 없어서 코드 실행 불가
    실제 실행해보면 NPE발생
    이 문제를 해결하려면 누군가 클라이언트인
    orderServiceImpl에 Discountpolicy의 구현 객체를 대신 생성하고 주입해주어야 한다.
     */
    private DisCountPolicy disCountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
