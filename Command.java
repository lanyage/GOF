package Register;


/**
 * Created by lanyage on 2018/5/22.
 */

/**
 * 命令模式
 * <p>
 * 将命令封装成类,然后一个命令对应一个Receiver,由invoker来启动命令的执行,
 * 用户需要感知Invoker和和command的存在,但是不需要知道具体底层是哪个接受者执行的,是一种高内聚的设计模式
 */
abstract class Receiver {
    public abstract void doSomething();
}

class AReceiver extends Receiver {

    @Override
    public void doSomething() {
        System.out.println("A do something!");
    }
}

class BReceiver extends Receiver {
    @Override
    public void doSomething() {
        System.out.println("B do something!");
    }
}

abstract class Command {
    protected Receiver receiver;

    public abstract void execute();
}

class ACommand extends Command {
    private static final Receiver receiver = new AReceiver();

    @Override
    public void execute() {
        receiver.doSomething();
    }
}

class BCommand extends Command {
    private static final BReceiver receiver = new BReceiver();

    @Override
    public void execute() {
        receiver.doSomething();
    }
}

class Invoker {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action() {
        command.execute();
    }
}

class Client {
    public static void main(String[] args) {
        Command command = new ACommand();
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.action();

        Command command1 = new BCommand();
        invoker.setCommand(command1);
        invoker.action();
    }
}
