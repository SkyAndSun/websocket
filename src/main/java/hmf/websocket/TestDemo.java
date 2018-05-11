package hmf.websocket;

import hmf.websocket.service.TaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by suneee on 2018/5/11.
 */
public class TestDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new TestDemo().task();
        AnnotationConfigApplicationContext entity = new AnnotationConfigApplicationContext(TaskService.class);



    }

    public void task(){
        Timer timer = new Timer();
        timer.schedule(new doTask(),5000);
    }

    class doTask extends TimerTask {

        @Override
        public void run() {
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "********已经启动了5秒 ----进入测试-----------");
        }
    }
}
