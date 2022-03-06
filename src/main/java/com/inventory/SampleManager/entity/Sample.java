package com.inventory.SampleManager.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    private String externalId;

    private String name;
}
