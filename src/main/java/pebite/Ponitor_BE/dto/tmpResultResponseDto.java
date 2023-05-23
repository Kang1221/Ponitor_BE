package pebite.Ponitor_BE.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class tmpResultResponseDto {

    private Long customerId;

    private List <String> emotions;

    private Long total;


}
