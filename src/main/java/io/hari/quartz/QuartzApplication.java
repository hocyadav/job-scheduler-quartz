package io.hari.quartz;

import java.util.Properties;
import java.util.stream.IntStream;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import io.hari.quartz.crons.MyCron1;
import io.hari.quartz.crons.MyCron10;
import io.hari.quartz.crons.MyCron2;
import io.hari.quartz.crons.MyCron3;
import io.hari.quartz.crons.MyCron4;
import io.hari.quartz.crons.MyCron5;
import io.hari.quartz.crons.MyCron6;
import io.hari.quartz.crons.MyCron7;
import io.hari.quartz.crons.MyCron8;
import io.hari.quartz.crons.MyCron9;

@SpringBootApplication
@EnableScheduling//2. working annotation based
public class QuartzApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(QuartzApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {//A2. create job and trigger and schedule : working
        // create JOB + TRIGGER
//        final JobDetail jobDetail = JobBuilder.newJob(MyCron1.class).build();
//        final SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-identity")
//                                                  .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(1).repeatForever())
//                                                  .build();

        //not working
//        final CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger-identity-2")
//                                                .withSchedule(CronScheduleBuilder.cronSchedule("0/2 0 0 ? * * *")).build();
//
//         create scheduler -> start scheduler -> schedule job and trigger
//        final Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        scheduler.start();
//        scheduler.scheduleJob(jobDetail, trigger);

        //m2 working

//        final SchedulerFactory factory = new StdSchedulerFactory();
        final SchedulerFactory factory = new StdSchedulerFactory("quartz_priority.properties");

//        Properties properties = new Properties();
//        properties.setProperty("org.quartz.threadPool.threadCount", "100");
//        properties.setProperty("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
//        properties.setProperty("org.quartz.jobStore.class", "org.quartz.simpl.RAMJobStore");
//        final SchedulerFactory factory = new StdSchedulerFactory(properties);


        final Scheduler scheduler = factory.getScheduler();
        scheduler.start();//3. start scheduler





//        scheduler.scheduleJob(jobDetail, trigger);
//
//
//        final JobDetail jobDetai2l = JobBuilder.newJob(MyCron1.class).build();
//        final SimpleTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger-identity2")
//                                                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(1).repeatForever())
//                                                    .build();
//
//        scheduler.scheduleJob(jobDetai2l, trigger2);
//
//        final JobDetail jobDetai2l3 = JobBuilder.newJob(MyCron1.class).build();
//        final SimpleTrigger trigger3 = TriggerBuilder.newTrigger().withIdentity("trigger-identity3")
//                                                     .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(1).repeatForever())
//                                                     .build();
//        scheduler.scheduleJob(jobDetai2l3, trigger3);

        scheduler.scheduleJob(JobBuilder.newJob(MyCron1.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity1").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());

        scheduler.scheduleJob(JobBuilder.newJob(MyCron2.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity2").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron3.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity3").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron4.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity4").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron5.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity5").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron6.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity6").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron7.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity7").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron8.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity8").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron9.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity9").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
        scheduler.scheduleJob(JobBuilder.newJob(MyCron10.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity10").withSchedule(
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());


        IntStream.range(11, 100).forEach(i -> {
            try {
                scheduler.scheduleJob(JobBuilder.newJob(MyCron2.class).build(), TriggerBuilder.newTrigger().withIdentity("trigger-identity"+i).withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        });


    }


//    @Scheduled(fixedDelay = 1000)//1. working
//    public void foo() {
//        System.err.println("QuartzApplication.foo");
//    }

//    @Scheduled(cron = "0/2 0 0 ? * * *")//1. not working
//    public void foo2() {
//        System.err.println("QuartzApplication.foo2");
//    }
}
