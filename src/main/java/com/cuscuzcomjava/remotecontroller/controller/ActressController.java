package com.cuscuzcomjava.remotecontroller.controller;

import com.cuscuzcomjava.remotecontroller.entity.Actress;
import com.cuscuzcomjava.remotecontroller.entity.Reserve;
import com.cuscuzcomjava.remotecontroller.service.ActressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ActressController {

    @Autowired
    ActressService service;

    @PostMapping("/create-actress")
    public ResponseEntity<Actress> createActress(@RequestBody Actress actress) throws Exception {
        return ResponseEntity.ok(service.createActress(actress));
    }

    @GetMapping("/actresses")
    public ResponseEntity<List<Actress>> getAllActresses(){
        return ResponseEntity.ok(service.getAllActresses());
    }

    @GetMapping("/actress/{id}")
    public ResponseEntity<Optional<Actress>> getActress(@PathVariable Long id){
        return ResponseEntity.ok(service.getActress(id));
    }

    @GetMapping("/actress-reserves/{id}")
    public ResponseEntity<List<Reserve>> searchReserves(@PathVariable Long id){
        return ResponseEntity.ok(service.searchReserves(id));
    }

}