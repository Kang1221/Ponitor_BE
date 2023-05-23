package pebite.Ponitor_BE.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
public class ResultUpdateRequestDto {

    private Long anger;

    private Long annoyance;

    private Long disapproval;

    private Long disquietment;

    private Long confusion;

    private Long sadness;

    private Long suffering;

    private Long total;

    @Builder
    public ResultUpdateRequestDto(Long anger, Long annoyance,
                  Long disapproval, Long disquietment, Long confusion,  Long sadness,
                  Long suffering, Long total){
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
