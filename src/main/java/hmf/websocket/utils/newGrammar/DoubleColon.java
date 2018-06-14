package hmf.websocket.utils.newGrammar;

import java.util.Arrays;
import java.util.List;

/**
 * java8 :: 用法 （JDK8 双冒号用法）
 */
public class DoubleColon {

    public static void printValur(String str){
        System.out.println("print value:"+str);
    }

    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("a","b","c");

        for (String s : arrayList)
            DoubleColon.printValur(s);

        //新的写法,与上面的循环等价
        arrayList.forEach(x->{
            DoubleColon.printValur(x);
        });

    }

}
