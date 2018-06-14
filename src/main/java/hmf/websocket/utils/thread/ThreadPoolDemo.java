package hmf.websocket.utils.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 多线程ExecutorService中submit和execute区别

 submit和execute都是 ExecutorService 的方法，都是添加线程到线程池中。

 区别
    submit 有返回值 返回future ， execute没有

     submit 返回值 future 用处
     可以执行cancle方法，取消执行
     可以通过get()方法，判断是否执行成功 ==null表示执行成功
 */
public class ThreadPoolDemo {

    class ThreadDemo implements Runnable{

        @Override
        public void run() {
            System.out.println("hello world");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadPoolDemo threadPoolDemo = new ThreadPoolDemo();

        for (int i = 0; i < 5; i++) {
            ThreadDemo threadDemo = threadPoolDemo.new ThreadDemo();
            Future<?> future = executorService.submit(threadDemo);

            System.out.println("--------------------------------");
            //可以取消执行
            future.cancel(true);

            //可以获取返回结构，如果future.get() != null 且 无异常，表示执行成功
            try {
                if (future.get() != null)
                    System.out.println("执行成功！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }

        //关闭线程池
        executorService.shutdown();

    }
}
