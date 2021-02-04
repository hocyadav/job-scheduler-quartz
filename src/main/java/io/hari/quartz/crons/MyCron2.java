package io.hari.quartz.crons;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author HariomYadav
 * @since 03/02/21
 */
public class MyCron2 implements Job {
    public static AtomicInteger atomicInteger = new AtomicInteger(0);//A1 : implement job
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("MyCron2.started ----- "+ atomicInteger.incrementAndGet());
//        try {
//            Thread.sleep(2000);
            int x = 0;
            for (int i = 0; i < 5000; i++) {
                x++;
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 * 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
                System.out.println("i1 = " + (1 + 2));
            }

            System.out.println("completed MyCron2.ended ----- "+ atomicInteger.incrementAndGet() );
//        }
    }
}
