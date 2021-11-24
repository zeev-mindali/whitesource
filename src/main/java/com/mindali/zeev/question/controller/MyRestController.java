package com.mindali.zeev.question.controller;


import com.mindali.zeev.question.service.GraphService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MyRestController {
    public final GraphService graphService;

    @PostMapping  //get the json body in POST verb
    @SneakyThrows //handle Exceptions in spring style
    public ResponseEntity<?> getSolution(@RequestBody String userData){
        return new ResponseEntity<>(graphService.getNonReach(userData), HttpStatus.OK);
    }
}
