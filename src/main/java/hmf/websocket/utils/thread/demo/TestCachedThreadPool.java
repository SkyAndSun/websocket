package hmf.websocket.utils.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new TestRunnable());
            System.out.println("--------------a"+ i + "---------------");
        }
    }
}
