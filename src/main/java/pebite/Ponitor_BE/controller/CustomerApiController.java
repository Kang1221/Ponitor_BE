package pebite.Ponitor_BE.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CustomerApiController {
    private final CustomerService customerService;
}
