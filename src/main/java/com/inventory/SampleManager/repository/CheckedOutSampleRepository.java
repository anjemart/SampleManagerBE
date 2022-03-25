package com.inventory.SampleManager.repository;

import com.inventory.SampleManager.entity.CheckedOutSample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CheckedOutSampleRepository extends JpaRepository<CheckedOutSample, Integer> {

    @Query
    Optional<CheckedOutSample> findByCustomerIdAndSampleId(int customerId, int sampleId);

    @Query
    List<CheckedOutSample> findByFollowedUp(boolean followedUp);

    @Query
    List<CheckedOutSample> findAllByOrderByFollowedUp();

    @Query
    int countByFollowedUp(boolean followedUp);
}
