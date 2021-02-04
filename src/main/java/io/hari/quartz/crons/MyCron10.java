package io.hari.quartz.crons;

import java.util.concurrent.atomic.AtomicInteger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author HariomYadav
 * @since 03/02/21
 */
public class MyCron10 implements Job {//A1 : implement job
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("started MyCron10.execute "+ atomicInteger.incrementAndGet());

        try {
            Thread.sleep(10000);
        System.err.println("end MyCron10.execute");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
