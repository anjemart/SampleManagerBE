package com.inventory.SampleManager.controller;


import com.google.gson.Gson;
import com.inventory.SampleManager.entity.Sample;
import com.inventory.SampleManager.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SampleController {

    private final SampleRepository sampleRepository;

    @GetMapping("/")
    @ResponseBody
    public String getSamples() {
        Sample sample = Sample.builder()
                .externalId("123456")
                .name("berber")
                .build();
        sampleRepository.save(sample);
        return new Gson().toJson(sampleRepository.findAll());
        //return "Working";
    }

    @PostMapping("/")
    public String addSample() {
        return "";
    }
}
