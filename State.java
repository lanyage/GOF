package Register;

/**
 * 状态模式
 * 通过将类的状态封装成类来控制类的行为逻辑
 */

/**
 * Created by lanyage on 2018/5/22.
 */
public class Lift {
    public static final LiftState OPEN = new OpenState();
    public static final LiftState CLOSE = new CloseState();

    private LiftState currentState;

    public void setCurrentState(LiftState currentState) {
        this.currentState = currentState;
        currentState.setLift(this);
    }

    public void open() {
        this.currentState.open();
    }

    public void close() {
        this.currentState.close();
    }

    public void run() {
        this.currentState.run();
    }
}

abstract class LiftState {
    protected Lift lift;

    public void setLift(Lift lift) {
        this.lift = lift;
    }

    public abstract void open();

    public abstract void close();

    public abstract void stop();

    public abstract void run();
}

class OpenState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯打开");
        this.lift.setCurrentState(Lift.OPEN);
    }

    @Override
    public void close() {
        System.out.println("电梯关闭");
        this.lift.setCurrentState(Lift.CLOSE);
    }

    @Override
    public void stop() {

    }

    @Override
    public void run() {
        throw new RuntimeException("电梯打开的状态不能跑！");
    }
}

class CloseState extends LiftState {
    @Override
    public void open() {
        System.out.println("电梯打开");
        this.lift.setCurrentState(Lift.OPEN);
    }

    @Override
    public void close() {
        System.out.println("电梯关闭");
        this.lift.setCurrentState(Lift.CLOSE);
    }

    @Override
    public void stop() {

    }

    @Override
    public void run() {
        System.out.println("电梯上下");
    }
}

class Client {
    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setCurrentState(Lift.OPEN);

        lift.open();
//        lift.close();
        lift.run();
    }
}
