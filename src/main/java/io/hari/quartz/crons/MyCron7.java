package io.hari.quartz.crons;

import java.util.concurrent.atomic.AtomicInteger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author HariomYadav
 * @since 03/02/21
 */
public class MyCron7 implements Job {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);//A1 : implement job
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("MyCron7.execute "+ atomicInteger.incrementAndGet());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
