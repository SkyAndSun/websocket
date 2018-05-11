package hmf.websocket.utils.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 Timer是一种定时器工具，用来在一个后台线程计划执行指定任务。它可以计划执行一个任务一次或反复多次。
 TimerTask一个抽象类，实现了Runnable接口，它的子类代表一个可以被Timer计划的任务。


 单一任务
 */
public class TimerDemo {
    Timer timer;

    public void MyTaskRun(){
        timer = new Timer();
        timer.schedule(new MyTimerTask(),5000);
    }

    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("已经开始5秒钟------MyTimerTask is running.........");
        }
    }

    public static void main(String[] args) {
        new TimerDemo().MyTaskRun();
        System.exit(0);
    }
}
