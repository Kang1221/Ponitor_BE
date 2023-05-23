package pebite.Ponitor_BE.controller;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import pebite.Ponitor_BE.dto.ResultUpdateRequestDto;
import pebite.Ponitor_BE.dto.tmpResultResponseDto;
import pebite.Ponitor_BE.model.Result;
import pebite.Ponitor_BE.service.ResultService;
import pebite.Ponitor_BE.service.SendImageService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class SendImageApiController {

    private final SendImageService sendImageService;
    private final ResultService resultService;
    private final Result result;

    @PostMapping(value = "/customerimages/{customerId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE) //insert
     public tmpResultResponseDto sendImage( @RequestParam(value = "image") MultipartFile imageFile, @PathVariable Long customerId) {
        //tmpResultResponseDto responseDto;

        tmpResultResponseDto responseDto = sendImageService.sendImage(imageFile, customerId);
        //responseDto = sendImageService.sendImage(imageFile, customerId);

        //requestDto 값 넣어주기
//        ResultUpdateRequestDto requestDto = new ResultUpdateRequestDto();
//
//        List<String> emotions = responseDto.getEmotions();
//
//        System.out.println("result 값 확인할게용");
//        System.out.println(result.getAnger());
//
//        if(emotions.contains("anger"))
//            requestDto.setAnger(result.getAnger()+1L);
//        else
//            requestDto.setAnger(result.getAnger());
//
//        if(emotions.contains("annoyance"))
//            requestDto.setAnnoyance(result.getAnnoyance()+1L);
//        else
//            requestDto.setAnnoyance(result.getAnnoyance());
//        if(emotions.contains("disapproval"))
//            requestDto.setDisapproval(result.getDisapproval()+1L);
//        else
//            requestDto.setDisapproval(result.getDisapproval());
//        if(emotions.contains("disquietment"))
//            requestDto.setDisquietment(result.getDisquietment()+1L);
//        else
//            requestDto.setDisquietment(result.getDisquietment());
//        if(emotions.contains("confusion"))
//            requestDto.setConfusion(result.getConfusion()+1L);
//        else
//            requestDto.setConfusion(result.getConfusion());
//        if(emotions.contains("sadness"))
//            requestDto.setSadness(result.getSadness()+1L);
//        else
//            requestDto.setSadness(result.getSadness());
//        if(emotions.contains("suffering"))
//            requestDto.setSuffering(result.getSuffering()+1L);
//        else
//            requestDto.setSuffering(result.getSuffering());
//        if(emotions.contains("total"))
//            requestDto.setTotal(result.getTotal() + responseDto.getTotal());


       // resultService.update(responseDto.getCustomerId(), requestDto);
        resultService.update(responseDto);
        return responseDto;
    }
}
