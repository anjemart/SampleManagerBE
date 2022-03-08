package com.inventory.SampleManager.service;

import com.inventory.SampleManager.entity.Customer;
import com.inventory.SampleManager.entity.Sample;
import com.inventory.SampleManager.repository.CustomerRepository;
import com.inventory.SampleManager.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final CustomerRepository customerRepository;

    private final SampleRepository sampleRepository;

    public Sample addOrUpdateSample(Sample sample) {
        var dbSample = sampleRepository.findByExternalId(sample.getExternalId());
        if(dbSample.isPresent()) {
            sampleRepository.save(dbSample.get().toBuilder().name(sample.getName()).build());
        } else {
            sampleRepository.save(sample);
        }

        return sample;
    }

    public Customer addOrUpdateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

}
