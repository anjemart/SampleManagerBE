package com.inventory.SampleManager.controller;


import com.google.gson.Gson;
import com.inventory.SampleManager.entity.Customer;
import com.inventory.SampleManager.entity.Sample;
import com.inventory.SampleManager.entity.dto.RelationshipDto;
import com.inventory.SampleManager.repository.CustomerRepository;
import com.inventory.SampleManager.repository.SampleRepository;
import com.inventory.SampleManager.service.SampleService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SampleController {

    private final CustomerRepository customerRepository;
    private final SampleService sampleService;

    @GetMapping("/getSamples")
    @ResponseBody
    public String getSamples() {
        return new Gson().toJson(sampleService.getSamples());
    }

    @PostMapping(path = "/addSample")
    @ResponseBody
    public String addSample(@RequestBody Sample sample) {
        sampleService.addOrUpdateSample(sample);
        return "Success";
    }

    @GetMapping("/getCustomers")
    @ResponseBody
    public String getCustomers() {
        return new Gson().toJson(sampleService.getCustomers());
    }

    @PostMapping(path = "/addCustomer")
    @ResponseBody
    public String addCustomer(@RequestBody Customer customer) {
        sampleService.addOrUpdateCustomer(customer);
        return "Success";
    }

    @GetMapping("/getCheckedOutSamples")
    @ResponseBody
    public String getCheckedOutSamples() {
        return new Gson().toJson(sampleService.getCheckedOutSamples());
    }

    @PostMapping(path = "/addCheckedOutSamples")
    @ResponseBody
    public String addCheckedOutSamples(@RequestBody RelationshipDto relationshipRequest) {
        sampleService.checkoutSample(relationshipRequest);
        return "Success";
    }
}
