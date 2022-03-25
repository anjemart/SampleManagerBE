package com.inventory.SampleManager.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

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

    @CreatedDate
    private OffsetDateTime createdOn;

    @LastModifiedDate
    private OffsetDateTime lastModifiedOn;
}
