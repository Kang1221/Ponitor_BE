package pebite.Ponitor_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pebite.Ponitor_BE.model.Customer;


import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class CustomerSaveRequestDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endTime;

    private String atmId;

    @Builder
    public CustomerSaveRequestDto(LocalDateTime startTime,LocalDateTime endTime, String atmId){
        this.startTime = startTime;
        this.endTime = endTime;
        this.atmId = atmId;
    }

    public Customer toEntity(){
        return Customer.builder()
                .startTime(startTime)
                .endTime(endTime)
                .atmId(atmId).
                build();
    }
}

