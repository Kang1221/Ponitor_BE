package pebite.Ponitor_BE.dto;

import lombok.Getter;
import pebite.Ponitor_BE.model.Customer;

import java.time.LocalDateTime;

@Getter
public class CustomerResponseDto {

    private Long customerId;
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;
//    private String atmId;

    public CustomerResponseDto(Customer entity){
        this.customerId = entity.getCustomerId();
//        this.startTime = entity.getStartTime();
//        this.endTime = entity.getEndTime();
//        this.atmId = entity.getAtmId();
    }
}
