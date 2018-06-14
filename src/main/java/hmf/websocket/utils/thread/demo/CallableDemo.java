package hmf.websocket.utils.thread.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 execute方法，submit方法

 1、接收的参数不一样

 2、submit有返回值，而execute没有

 Method submit extends base method Executor.execute by creating and returning a Future that can be used to cancel execution and/or wait for completion.

 用到返回值的例子，比如说我有很多个做validation的task，我希望所有的task执行完，然后每个task告诉我它的执行结果，是成功还是失败，如果是失败，原因是什么。然后我就可以把所有失败的原因综合起来发给调用者。

 个人觉得cancel execution这个用处不大，很少有需要去取消执行的。

 而最大的用处应该是第二点。

 3、submit方便Exception处理

 */
public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 10 ; i++) {
            //使用ExecutorService执行Callable类型的任务，并将结果保存在future变量中
            Future<String> future = executorService.submit(new TaskWithResult(i));

            list.add(future);
        }

        for (Future<String> f:list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executorService.shutdown();
            }
        }
    }
}



class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {

        System.out.println("call...."+Thread.currentThread().getName());

        //模拟耗时操作
        for (int i = 0; i < 99999999; i++);

        return "call 调用结果："+ id + "  "+ Thread.currentThread().getName();
    }
}
