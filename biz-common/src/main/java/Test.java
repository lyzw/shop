import java.util.ArrayList;
import java.util.List;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/8/16
 * @since v1.0
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        int M = 102 * 1024 * 1024;
        List list = new ArrayList<byte[]>();
        int index = 0;
        while (true){
            Thread.sleep(10000);
            System.out.println(++index + ":次执行");
            list.add(new byte[M]);
        }
    }
}
