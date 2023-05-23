package pebite.Ponitor_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pebite.Ponitor_BE.model.Result;


@Getter
@NoArgsConstructor
public class ResultSaveRequestDto {
    private Long customerId;
    private Long withdraw;

    @Builder
    public ResultSaveRequestDto (Long customerId, Long withdraw){
        this.customerId = customerId;
        this.withdraw = withdraw;

    }

    public Result toEntity(){
        return Result.builder()
                .customerId(customerId)
                .withdraw(withdraw)
                .anger(0L).annoyance(0L).disquietment(0L).
                disapproval(0L).confusion(0L).suffering(0L).
                sadness(0L).total(0L)
                .build();
    }

}
