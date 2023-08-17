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


       // resultService.update(responseDto.getCustomerId(), requestDto);
        resultService.update(responseDto);
        return responseDto;
    }
}
