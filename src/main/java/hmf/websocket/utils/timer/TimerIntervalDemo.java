package hmf.websocket.utils.timer;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by suneee on 2018/5/11.
 */
public class TimerIntervalDemo {
    Toolkit toolkit;
    Timer timer;

    public TimerIntervalDemo() {
        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new MyTimerTask(),0,1000);
    }

    class MyTimerTask extends TimerTask{
        int num = 5;

        @Override
        public void run() {
            if (num >0){
                toolkit.beep();
                System.out.println("beep....");
                num --;
            }else{
                toolkit.beep();
                System.out.println("Timer is up....");
                timer.cancel();
              //  System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new TimerIntervalDemo();
    }
}
