package com.colak.springkafkatutorial.controller;

import com.colak.springkafkatutorial.service.consumer.ReplayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/replay")
@RequiredArgsConstructor
public class ReplayController {

    private final ReplayService replayService;

    @Value("${app.constant.kafka.metrics-topic-name}")
    private String metricsTopic;


    // http://localhost:8080/api/replay/metrics
    @GetMapping(path = "metrics")
    public void replayMetrics() {
        replayService.replayFromOffset(metricsTopic, 0, 0);
    }
}
