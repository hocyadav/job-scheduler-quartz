package io.hari.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling//2. working annotation based
public class QuartzApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {//A2. create job and trigger and schedule : working
        // create JOB + TRIGGER
        final JobDetail jobDetail = JobBuilder.newJob(MyCron.class).build();
        final SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-identity")
                                                  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                                                  .build();

        //not working
//        final CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-identity-2")
//                                                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 0 0 ? * * *")).build();
//
        // create scheduler -> start scheduler -> schedule job and trigger
        final Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }


    @Scheduled(fixedDelay = 1000)//1. working
    public void foo() {
        System.err.println("QuartzApplication.foo");
    }

//    @Scheduled(cron = "0/2 0 0 ? * * *")//1. not working
//    public void foo2() {
//        System.err.println("QuartzApplication.foo2");
//    }
}
