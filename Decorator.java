package Register;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 装饰器模式
 * 装饰器模式一般用于增强某些类的功能,相当于包饺子,一层一层的包装,在添加新功能的时候不改变被包装类的类结构
 * 包装类必须和原类实现一样的接口
 * 可以存在很多具体的包装类
 */
interface IRobot {
    public void sing();
}

class Robot implements IRobot {
    @Override
    public void sing() {
        System.out.println("robot sing.");
    }
}

abstract class Decorator implements IRobot {
    protected IRobot robot;

    public Decorator(IRobot robot) {
        this.robot = robot;
    }
}

class ClassMusicDecorator extends Decorator {

    public ClassMusicDecorator(IRobot robot) {
        super(robot);
    }

    @Override
    public void sing() {
        robot.sing();
        System.out.println("robot sing classic music.");
    }
}

class CountryMusicDecorator extends Decorator {

    public CountryMusicDecorator(IRobot robot) {
        super(robot);
    }

    @Override
    public void sing() {
        robot.sing();
        System.out.println("robot sing country music.");
    }
}

class Owner {
    public static void main(String[] args) {
        IRobot robot = new Robot();
        robot = new ClassMusicDecorator(robot);
        robot = new CountryMusicDecorator(robot);
        robot.sing();
    }
}
