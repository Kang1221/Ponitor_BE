package pebite.Ponitor_BE.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pebite.Ponitor_BE.model.Customer;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    @After //테스트 단위 끝날때마다 실행
    public void cleanup(){ //테스트 간 데이터 침범 막기위해 다 지움
        customerRepository.deleteAll();
    }

    @Test
    public void 고객정보_불러오기(){
        //given
        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime endTime = LocalDateTime.now();
        String atmId = "ewha001";

        customerRepository.save(Customer.builder()
                .startTime(startTime)
                .endTime(endTime)
                .atmId(atmId)
                .build());

        //when
        List<Customer> customerList = customerRepository.findAll();

        //then
        Customer customer = customerList.get(0);
        assertThat(customer.getStartTime()).isEqualTo(startTime);
        assertThat(customer.getEndTime()).isEqualTo(endTime);
        assertThat(customer.getAtmId()).isEqualTo(atmId);

    }


}
