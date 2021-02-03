package io.hari.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author HariomYadav
 * @since 03/02/21
 */
public class MyCron implements Job {//A1 : implement job
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("jobExecutionContext = " + jobExecutionContext);
        System.out.println("hario = ");
    }
}
