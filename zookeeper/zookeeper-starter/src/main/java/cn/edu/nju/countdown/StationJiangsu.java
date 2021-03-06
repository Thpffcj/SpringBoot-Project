package cn.edu.nju.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Thpffcj on 2018/4/25.
 */
public class StationJiangsu extends DangerCenter {

    public StationJiangsu(CountDownLatch countDown) {
        super(countDown, "江苏调度站");
    }

    @Override
    public void check() {
        System.out.println("正在检查 [" + this.getStation() + "]...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("检查 [" + this.getStation() + "] 完毕，可以发车~");
    }
}
