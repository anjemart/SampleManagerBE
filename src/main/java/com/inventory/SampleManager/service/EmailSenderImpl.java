package com.inventory.SampleManager.service;

import com.inventory.SampleManager.repository.CheckedOutSampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender{

    private final CheckedOutSampleRepository checkedOutSampleRepository;

    @Override
    public void sendEmail() {
        int needFollowup = checkedOutSampleRepository.countByFollowedUp(false);
        System.out.printf("Found %d relationships needing followup%n", needFollowup);
    }
}
