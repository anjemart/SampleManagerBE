package com.inventory.SampleManager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class EmailScheduler {

    private final EmailSender emailSender;

    @Scheduled(cron = "0 * * * * ?")
    public void checkForNeededFollowUps() {
        emailSender.sendEmail();
    }
}
