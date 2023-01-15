package com.multi.db.controller;

import com.multi.db.model.TestMultDbsModel;
import com.multi.db.service.TestMultDbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestMultDbsController {

    @Autowired private TestMultDbsService service;

    @GetMapping
    public ResponseEntity<List<TestMultDbsModel>> test(@RequestParam String test){
        return ResponseEntity.ok(service.test(test));
    }
}
