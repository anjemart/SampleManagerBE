package com.inventory.SampleManager.entity;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckedOutSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @ManyToOne
    @ToString.Exclude
    private Customer customer;

    @ManyToOne
    @ToString.Exclude
    private Sample sample;

    private OffsetDateTime createdOn;

    private OffsetDateTime lastModifiedOn;
}
