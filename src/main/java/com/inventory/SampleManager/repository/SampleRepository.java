package com.inventory.SampleManager.repository;

import com.inventory.SampleManager.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SampleRepository extends JpaRepository<Sample, Integer> {

    @Query
    public Optional<Sample> findByExternalId(String id);
}
