package ru.skillfactory;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.apache.log4j.BasicConfigurator;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzExample {

    public static void main(String[] args) throws SchedulerException, InterruptedException {

        BasicConfigurator.configure();


        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        JobDetail job = newJob(HelloJob.class)
                .withIdentity("skillfactoryIdentity")
                .build();

        Date runTime = evenMinuteDate(new Date());

        Trigger trigger = newTrigger()
                .withIdentity("skillfactory")
                .startAt(runTime)
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(30 * 1000);

        scheduler.shutdown();

    }
}
