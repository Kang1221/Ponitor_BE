package pebite.Ponitor_BE.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import pebite.Ponitor_BE.dto.CustomerSaveRequestDto;
import pebite.Ponitor_BE.dto.CustomerUpdateRequestDto;
import pebite.Ponitor_BE.service.CustomerService;

@RequiredArgsConstructor
@RestController
public class CustomerApiController {

    private final CustomerService customerService;

    @PostMapping("/users/{username}/lists") //insert
    public Long save(@RequestBody CustomerSaveRequestDto requestDto){
        return customerService.save(requestDto);
    }

//    @PutMapping("/users/{username}/lists")//update
//    public Long update(@PathVariable Long customerId, @RequestBody CustomerUpdateRequestDto requestDto){
//        return customerService.update(customerId, requestDto);
//    }

    @PutMapping("/users/{username}/lists")//update
    public Long update(@RequestBody CustomerUpdateRequestDto requestDto){
        return customerService.update(requestDto);
    }

}
