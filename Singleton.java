package Register;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lanyage on 2018/5/14.
 */

/**
 * 单例模式
 * 应用场景:如果对于每一个类要控制其实例的个数为单例,那么就可以用单例模式,比如说各种配置类
 */
class SingleTon {
    private static SingleTon singleTon;

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        synchronized (SingleTon.class) {
            if (singleTon == null) {
                singleTon = new SingleTon();
            }
        }
        return singleTon;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + " " + SingleTon.getInstance().hashCode());
                }
            });
        }
        executorService.shutdown();
    }
}

/**
 * 直接提供一个共有的不可变的INSTANCE实例,类似于枚举
 */
class SingleTon2 {
    private SingleTon2() {
    }

    public static final SingleTon2 INSTANCE = new SingleTon2();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + " " + SingleTon2.INSTANCE.hashCode());
                }
            });
        }
        executorService.shutdown();
    }
}

/**
 * 使用枚举来实现单例模式
 */
enum SingleTon3 {
    INSTANCE;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread() + " " + SingleTon3.INSTANCE.hashCode());
                }
            });
        }
        executorService.shutdown();
    }
}
