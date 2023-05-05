package pebite.Ponitor_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CustomerUpdateRequestDto {
    private Long customerId;
    private LocalDateTime endTime;
    @Builder
    public CustomerUpdateRequestDto( Long customerId, LocalDateTime endTime){
        this.customerId= customerId;
        this.endTime = endTime;
    }
}
