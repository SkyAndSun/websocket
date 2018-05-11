package hmf.websocket.utils.schedual;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务
 */
@Component
@Configurable
@EnableScheduling
public class TaskA implements MyTask{

    @Scheduled(cron = "0/5 * * * * ?")//每5秒执行一次
    public void task(){

        try{
            Thread.sleep(1000);

        } catch (Exception e){
            e.printStackTrace();
        }

        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        System.out.println(df.format(new Date()) + "********A任务每5秒执行一次进入测试----------------TaskA");

    }

}
