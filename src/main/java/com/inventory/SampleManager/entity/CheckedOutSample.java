package com.inventory.SampleManager.entity;

import javax.persistence.Entity;
import java.time.OffsetDateTime;


public class CheckedOutSample {


    private Customer customer;

    private Sample sample;

    private OffsetDateTime createdOn;

    private OffsetDateTime lastModifiedOn;
}
