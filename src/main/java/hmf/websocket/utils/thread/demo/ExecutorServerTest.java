package hmf.websocket.utils.thread.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServerTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new TaskWithResult01(i));
            list.add(future);
        }
        executorService.shutdown();

        for (Future<String> f:list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                executorService.shutdownNow();
                e.printStackTrace();
                return;
            }
        }

    }
}


class TaskWithResult01 implements Callable<String>{
    private int id;

    public TaskWithResult01(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Call开始-----"+Thread.currentThread().getName());

//        if(new Random().nextBoolean())
//            new TaskException("task error ---"+ Thread.currentThread().getName());
        if(id>7)
            new TaskException("task error ---"+ Thread.currentThread().getName());

        for (int i = 0; i < 999999999; i++);


        return "call 结果："+ id + ": "+ Thread.currentThread().getName();
    }
}


class TaskException extends Exception{
    public TaskException(String message) {
        super(message);
    }
}