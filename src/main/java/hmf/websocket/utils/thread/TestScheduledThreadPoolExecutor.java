package hmf.websocket.utils.thread;


import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
newScheduledThreadPool

 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
 */
public class TestScheduledThreadPoolExecutor {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"==================");
            }
        },1000,5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"*************");
            }
        },1000,2000,TimeUnit.MILLISECONDS);

    }
}
