package pebite.Ponitor_BE.service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pebite.Ponitor_BE.dto.CustomerUpdateRequestDto;
import pebite.Ponitor_BE.dto.ResultSaveRequestDto;
import pebite.Ponitor_BE.dto.ResultUpdateRequestDto;
import pebite.Ponitor_BE.dto.tmpResultResponseDto;
import pebite.Ponitor_BE.model.Customer;
import pebite.Ponitor_BE.model.Result;
import pebite.Ponitor_BE.repository.ResultRepository;

import javax.persistence.Column;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResultService {
    private final ResultRepository resultRepository;

    //출금액 저장
    @Transactional
    public Long save(ResultSaveRequestDto requestDto){
        return resultRepository.save(requestDto.toEntity()).getCustomerId();
    }

    //감정 값 업데이트
    @Transactional
    public Long update(tmpResultResponseDto tmpresponseDto) {
        Result result = resultRepository.findById(tmpresponseDto.getCustomerId())
                .orElseThrow(()-> new IllegalArgumentException("해당 고객이 존재하지 않습니다." + tmpresponseDto.getCustomerId() ));

        //Result.update( result.getAnger()+1L, result.getAnnoyance()+1L, disapproval, disquietment, confusion, sadness, suffering, total);

        ResultUpdateRequestDto requestDto = new ResultUpdateRequestDto();
        List<String> emotions = tmpresponseDto.getEmotions();

        System.out.println("result 값 확인할게용");
        System.out.println(result.getAnger());

        if(emotions.contains("anger"))
            requestDto.setAnger(result.getAnger()+1L);
        else
            requestDto.setAnger(result.getAnger());

        if(emotions.contains("annoyance"))
            requestDto.setAnnoyance(result.getAnnoyance()+1L);
        else
            requestDto.setAnnoyance(result.getAnnoyance());
        if(emotions.contains("disapproval"))
            requestDto.setDisapproval(result.getDisapproval()+1L);
        else
            requestDto.setDisapproval(result.getDisapproval());
        if(emotions.contains("disquietment"))
            requestDto.setDisquietment(result.getDisquietment()+1L);
        else
            requestDto.setDisquietment(result.getDisquietment());
        if(emotions.contains("confusion"))
            requestDto.setConfusion(result.getConfusion()+1L);
        else
            requestDto.setConfusion(result.getConfusion());
        if(emotions.contains("sadness"))
            requestDto.setSadness(result.getSadness()+1L);
        else
            requestDto.setSadness(result.getSadness());
        if(emotions.contains("suffering"))
            requestDto.setSuffering(result.getSuffering()+1L);
        else
            requestDto.setSuffering(result.getSuffering());

        requestDto.setTotal(result.getTotal() + tmpresponseDto.getTotal());

        result.update(requestDto);
        //return resultRequestDto.getCustomerId();
        return  tmpresponseDto.getCustomerId();
    }
}
