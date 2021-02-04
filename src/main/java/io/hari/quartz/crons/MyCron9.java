package io.hari.quartz.crons;

import java.util.concurrent.atomic.AtomicInteger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author HariomYadav
 * @since 03/02/21
 */
public class MyCron9 implements Job {//A1 : implement job
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("MyCron9.execute " + atomicInteger.incrementAndGet());
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
