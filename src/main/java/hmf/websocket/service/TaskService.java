package hmf.websocket.service;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Configurable
@EnableScheduling
public class TaskService {

    @Scheduled(cron="0/5 * * * * ?")
    public void task() {
        System.out.println(new SimpleDateFormat("HH:mm:ss").format(new Date()) + "********B任务每5秒执行一次进入测试");
    }
}
