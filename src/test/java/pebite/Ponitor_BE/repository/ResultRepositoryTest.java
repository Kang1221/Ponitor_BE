package pebite.Ponitor_BE.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pebite.Ponitor_BE.model.Result;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultRepositoryTest {

    @Autowired
    ResultRepository resultRepository;

    @After //테스트 단위 끝날때마다 실행
    public void cleanup(){ //테스트 간 데이터 침범 막기위해 다 지움
        resultRepository.deleteAll();
    }

    @Test
    public void Result_불러오기(){
//        //given
//        Long withdraw = 10;
//        boolean isPhone = 0;
//        boolean isAlert = 0;
//
//        resultRepository.save(Result.builder()
//                .withdraw(withdraw)
//                .isPhone(isPhone)
//                .isAlert(isAlert)
//                .build());
//
//        //when
//        List<Result> resultList = resultRepository.findAll();
//
//        //then
//        Result result = resultList.get(0);
//        assertThat(result.getWithdraw()).isEqualTo(withdraw);
////        assertThat(result.()).isEqualTo(isPhone);
////        assertThat(result.get()).isEqualTo(isAlert);

    }

}
