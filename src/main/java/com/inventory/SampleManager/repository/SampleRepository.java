package com.inventory.SampleManager.repository;

import com.inventory.SampleManager.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<Sample, Integer> {

}
