package pebite.Ponitor_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pebite.Ponitor_BE.model.Result;

@Getter
@NoArgsConstructor//기본 생성자 생성
public class ResultSaveRequestDto {
    private Long customerId;
    private Long withdraw;
    private boolean phone;
    private boolean victim;

    @Builder
    public  ResultSaveRequestDto(Long customerId, Long withdraw, boolean phone, boolean victim){
        this.customerId = customerId;
        this.withdraw = withdraw;
        this.phone = phone;
        this.victim = victim;
    }

    public Result toEntity(){
        return  Result.builder()
                .customerId(customerId)
                .withdraw(withdraw)
                .phone(phone)
                .victim(victim)
                .build();
    }

}
