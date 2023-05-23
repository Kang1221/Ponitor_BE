package pebite.Ponitor_BE.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pebite.Ponitor_BE.dto.ResultUpdateRequestDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter// 클래스내 getter 메소드 자동생성
@NoArgsConstructor //기본 생성자 자동추가
@Component
@Entity
public class Result {

    @Id
    private Long customerId;

    @Column
    private Long withdraw;

    @Column(nullable = true)
    private boolean phone;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long anger;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long annoyance;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long disapproval;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long disquietment;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long confusion;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long sadness;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long suffering;

    @Column(nullable = true)
    @ColumnDefault("0L")
    private Long total;


    @Builder
    public Result(Long customerId, Long withdraw, boolean phone, Long anger, Long annoyance,
                  Long disapproval, Long disquietment, Long confusion,  Long sadness,
                  Long suffering, Long total){
        this.customerId = customerId;
        this.withdraw = withdraw;
        this.phone = phone;
        this.anger = anger;
        this.annoyance = annoyance;
        this.disapproval = disapproval;
        this.disquietment = disquietment;
        this.confusion = confusion;
        this.sadness = sadness;
        this.suffering = suffering;
        this.total = total;
    }

    public void update(ResultUpdateRequestDto requestDto){

        Long anger = requestDto.getAnger();
        Long annoyance= requestDto.getAnnoyance();
        Long disapproval = requestDto.getDisapproval();
        Long disquietment=requestDto.getDisquietment();
        Long confusion = requestDto.getConfusion();
        Long sadness = requestDto.getSadness();
        Long suffering = requestDto.getSuffering();
        Long total = requestDto.getTotal();


        this.anger = anger;
        this.annoyance = annoyance;
        this.disapproval = disapproval;
        this.disquietment = disquietment;
        this.confusion = confusion;
        this.sadness = sadness;
        this.suffering = suffering;
        this.total = total;
    }

}
