package com.inventory.SampleManager.service;

import com.inventory.SampleManager.entity.CheckedOutSample;
import com.inventory.SampleManager.entity.Customer;
import com.inventory.SampleManager.entity.Sample;
import com.inventory.SampleManager.entity.dto.RelationshipDto;
import com.inventory.SampleManager.repository.CheckedOutSampleRepository;
import com.inventory.SampleManager.repository.CustomerRepository;
import com.inventory.SampleManager.repository.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SampleService {

    private final CustomerRepository customerRepository;

    private final SampleRepository sampleRepository;

    private final CheckedOutSampleRepository checkedOutSampleRepository;

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

    public List<CheckedOutSample> checkoutSample(RelationshipDto relationshipRequest) {
        List<CheckedOutSample> checkedOutSamples = new ArrayList<>();
        var customerId = relationshipRequest.getCustomerId();
        for(Integer sampleId: relationshipRequest.getSampleIds()) {
            var existingRelationship = checkedOutSampleRepository.findByCustomerIdAndSampleId(customerId, sampleId);
            var checkedOutSample = existingRelationship.orElseGet(() -> CheckedOutSample.builder()
                    .customer(customerRepository.getById(customerId))
                    .createdOn(OffsetDateTime.now())
                    .sample(sampleRepository.getById(sampleId))
                    .followedUp(false)
                    .build());
            checkedOutSample.setLastModifiedOn(OffsetDateTime.now());
            checkedOutSamples.add(checkedOutSample);
            checkedOutSampleRepository.save(checkedOutSample);
        }

        return checkedOutSamples;
    }

    public List<CheckedOutSample> getCheckedOutSamples() {
        return checkedOutSampleRepository.findAll();
    }
}
