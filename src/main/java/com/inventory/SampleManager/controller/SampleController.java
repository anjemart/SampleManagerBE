package com.inventory.SampleManager.controller;


import com.google.gson.Gson;
import com.inventory.SampleManager.entity.Customer;
import com.inventory.SampleManager.entity.Sample;
import com.inventory.SampleManager.repository.CustomerRepository;
import com.inventory.SampleManager.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SampleController {

    private final SampleRepository sampleRepository;
    private final CustomerRepository customerRepository;

    @GetMapping("/getSamples")
    @ResponseBody
    public String getSamples() {
        return new Gson().toJson(sampleRepository.findAll());
    }

    @PostMapping(path = "/addSample")
    @ResponseBody
    public String addSample(@RequestBody Sample sample) {
        sampleRepository.save(sample);
        return "Success";
    }

    @GetMapping("/getCustomers")
    @ResponseBody
    public String getCustomers() {
        return new Gson().toJson(customerRepository.findAll());
    }

    @PostMapping(path = "/addCustomer")
    @ResponseBody
    public String addCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }

    @GetMapping("/getCheckedOutSamples")
    @ResponseBody
    public String getCheckedOutSamples() {
        return new Gson().toJson(customerRepository.findAll());
    }

    @PostMapping(path = "/addCheckedOutSamples")
    @ResponseBody
    public String addCheckedOutSamples(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return "Success";
    }
}
