package com.example.trip.util;

import java.util.TimeZone;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.example.trip.data.BreweryCrawlerJob;
import com.example.trip.data.CustomJobFactory;

@Configuration
public class QuartzConfig {

    @Autowired
    private CustomJobFactory customJobFactory;

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(BreweryCrawlerJob.class);
        factoryBean.setDescription("Invoke Brewery Crawler Job service...");
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetail) {
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression("0 0 4 1 * ?"); // 매달 1일 오전 4시 실행
        factoryBean.setTimeZone(TimeZone.getTimeZone("Asia/Seoul")); // 한국 시간대 설정
        factoryBean.setMisfireInstruction(org.quartz.CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        return factoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTrigger cronTrigger, JobDetail jobDetail) {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setJobFactory(customJobFactory);
        factory.setJobDetails(jobDetail);
        factory.setTriggers(cronTrigger);
        return factory;
    }

    @Bean
    public CronTrigger cronTrigger(JobDetail jobDetail) {
        return TriggerBuilder.newTrigger()
            .forJob(jobDetail)
            .withIdentity("BreweryCrawlerTrigger")
            .withDescription("Brewery Crawler Trigger")
            .withSchedule(CronScheduleBuilder.cronSchedule("0 0 4 1 * ?")
                .inTimeZone(TimeZone.getTimeZone("Asia/Seoul"))
                .withMisfireHandlingInstructionDoNothing()) // 미스파이어 시 아무 작업도 수행하지 않음
            .build();
    }
}
