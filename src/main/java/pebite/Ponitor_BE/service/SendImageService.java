package pebite.Ponitor_BE.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import pebite.Ponitor_BE.dto.tmpResultResponseDto;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class SendImageService {


    @Transactional
    public tmpResultResponseDto sendImage(MultipartFile imageFile, Long customerId){
        if (!imageFile.isEmpty()) {

            //사진 형태 변환
            MultipartBodyBuilder builder = new MultipartBodyBuilder();
            builder.part("file", imageFile.getResource());

            //AI 서버
            WebClient client = WebClient.builder().baseUrl("http://43.134.36.2:8000").build();

            // WebClient Post 호출
            tmpResultResponseDto result = client.post()
                    .uri("/infer/{customerId}",customerId)
                    .contentType(MediaType.MULTIPART_FORM_DATA)
                    .body(BodyInserters.fromMultipartData(builder.build()))
                    .retrieve()
                    .bodyToMono(tmpResultResponseDto.class)
                    .block(); //1개의 값을 리턴할 때는 bodyToMono, 복수의 값을 리턴할 때는 bodyToFlux

            return result;

        }


        else{
            return null;
        }

    }




}
