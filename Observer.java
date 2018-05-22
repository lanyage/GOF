import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanyage on 2018/5/22.
 */

/**
 * 观察者模式
 * 让所有的观察者在被观察者更新消息的时候就立马收到推送，例子有微信公众号的文章推送
 */
interface Observable {
    void notifyAllUser();

    void update(String msg);

    void register(Observer observer);
}

interface Observer {
    void receive(String message);

    void read();
}

class Subscriber implements Observer {
    private String dailyMsg;
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void receive(String message) {
        this.dailyMsg = message;
        read();
    }

    @Override
    public void read() {
        System.out.println(this.name + " read " + dailyMsg);
    }
}

class PublicAccount implements Observable {
    private List<Observer> subscribers = new ArrayList<>();
    private String message;

    @Override
    public void notifyAllUser() {
        for (Observer observer : subscribers) {
            observer.receive(message);
        }
    }

    @Override
    public void update(String msg) {
        System.out.println("public account update........");
        this.message = msg;
        notifyAllUser();
    }

    @Override
    public void register(Observer observer) {
        this.subscribers.add(observer);
    }
}

class Main {
    public static void main(String[] args) {
        Observable publicAccount = new PublicAccount();
        Observer user = new Subscriber("张三");
        Observer user2 = new Subscriber("李四");
        publicAccount.register(user);
        publicAccount.register(user2);
        publicAccount.update("java是最好的语言...");

        publicAccount.register(new Subscriber("王五"));
        publicAccount.update("php是世界上最好的语言...");
    }
}
