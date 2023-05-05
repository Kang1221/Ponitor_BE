package pebite.Ponitor_BE.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter// 클래스내 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동추가
@Entity
public class Result { //판단 결과 저장 엔티티

    @Id
    private Long customerId; //foreigner 키 지정할지, 프론트에서 갖고 있다가 같이 줄지

    @Column
    private Long withdraw; //만원단위

    @Column(nullable = true)
    private boolean phone;

    @Column(nullable = true)
    private boolean victim;

    @Builder
    public Result( Long customerId, Long withdraw, boolean phone, boolean victim){
        this.customerId = customerId;
        this.withdraw = withdraw;
        this.phone = phone;
        this.victim = victim;
    }
}
