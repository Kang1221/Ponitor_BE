package pebite.Ponitor_BE.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pebite.Ponitor_BE.dto.CustomerResponseDto;
import pebite.Ponitor_BE.dto.CustomerSaveRequestDto;
import pebite.Ponitor_BE.dto.CustomerUpdateRequestDto;
import pebite.Ponitor_BE.model.Customer;
import pebite.Ponitor_BE.repository.CustomerRepository;

@RequiredArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Transactional
    public Long save(CustomerSaveRequestDto requestDto) {
        return customerRepository.save(requestDto.toEntity()).getCustomerId();
    }

//    @Transactional
//    public Long update(Long customerId, CustomerUpdateRequestDto requestDto){
//        Customer customer = customerRepository.findById(customerId)
//                .orElseThrow(()-> new IllegalArgumentException("해당 고객이 존재하지 않습니다. customer_id = "+customerId));
//
//        customer.update(requestDto.getEndTime());
//        return customerId;
//    }

    @Transactional
    public Long update(CustomerUpdateRequestDto requestDto) {
        Long customerId = requestDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(()-> new IllegalArgumentException("해당 고객이 존재하지 않습니다. customer_id = "+customerId));

        customer.update(requestDto.getEndTime());
        return customerId;
    }

    public CustomerResponseDto findById( Long customerId){
        Customer entity = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("해당 고객이 존재하지 않습니다. customer_id = " + customerId));
        return new CustomerResponseDto(entity);
    }

}
