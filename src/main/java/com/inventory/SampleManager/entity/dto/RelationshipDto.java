package com.inventory.SampleManager.entity.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class RelationshipDto {

    private final int customerId;

    private final List<Integer> sampleIds;


}
