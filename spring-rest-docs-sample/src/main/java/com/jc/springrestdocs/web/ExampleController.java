package com.jc.springrestdocs.web;

import com.jc.springrestdocs.web.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/example")
    public ResponseEntity<ResponseDto> example1() {
        return ResponseEntity.ok(new ResponseDto(1L, "ex"));
    }
}