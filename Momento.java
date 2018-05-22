package Register;

/**
 * Created by lanyage on 2018/5/22.
 */

/**
 * 备忘录模式
 * <p>
 * 回到过去 此处使用的是自述历史,其实GOF最先版还有一个CareTaker
 */
public class Origin {
    private int state;
    private Momento momento;

    public void createMomento() {
        momento = new Momento();
        momento.setState(state);
    }

    public void retriveMomento() {
        setState(momento.getState());
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "state=" + state +
                '}';
    }
}

class Momento {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

class Main {
    public static void main(String[] args) {
        Origin origin = new Origin();
        origin.setState(1);
        origin.createMomento();
        System.out.println(origin);

        origin.setState(100);
        System.out.println(origin);

        origin.retriveMomento();
        System.out.println(origin);
    }
}
