package com.example.trip.data;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class BreweryCrawlerJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        BreweryCrawler crawler = new BreweryCrawler();
        crawler.executeCrawl();
    }
}