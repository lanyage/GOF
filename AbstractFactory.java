package Register;

/**
 * Created by lanyage on 2018/5/18.
 */

/**
 * 抽象工厂
 * 一般适用于产品线比较复杂的模型
 * 如产品类有电脑,平板和手机,那么抽象工厂可以抽象为newPhone(),newPad,newLaptop(),这个工厂是抽象的
 * 分别有苹果工厂和三星工厂继承自抽象工厂,那么它们都会继承父类的创建方法,然后自己根据自身的品牌来生产同
 * 类型的产品。
 *
 * 缺点:如果增加了一个产品类型,如电脑,那么不得不修改所有的工厂抽象类和实现类,大动干戈。
 * 有点:如果用户突然对华为有了需求,需要华为的手机和平板,那么就添加一个华为手机和平板实现类,然后再创建工厂就可以了。
 */
abstract class SmartPhone {
    public abstract void sayName();
}

abstract class Pad {
    public abstract void sayName();
}

class Iphone extends SmartPhone {
    @Override
    public void sayName() {
        System.out.println("I am an Iphone8X.Oops.");
    }
}

class GalaxyS9 extends SmartPhone {
    @Override
    public void sayName() {
        System.out.println("I am Samsung Galaxy9.BUY ME PLEASE.");
    }
}

class IpadPro extends Pad {

    @Override
    public void sayName() {
        System.out.println("I am an Ipad Pro.Love you.");
    }
}

class SamsungPad extends Pad {
    @Override
    public void sayName() {
        System.out.println("I am an Samsung pad.I am your friend.");
    }
}
class Nova2 extends SmartPhone {

    @Override
    public void sayName() {
        System.out.println("I am Nova2 from Huawei.I belong with you.");
    }
}
class HuaweiPad extends Pad {

    @Override
    public void sayName() {
        System.out.println("I am Huawei Pad,It will be a right choice to pick me as your personal pad.");
    }
}
abstract class AbstractDigitsFactory {
    public abstract void sayBranch();

    public abstract SmartPhone createSmartPhone();

    public abstract Pad createPad();
}

class AppleFactory extends AbstractDigitsFactory {

    @Override
    public void sayBranch() {
        System.out.println("Apple.Inc");
    }

    @Override
    public SmartPhone createSmartPhone() {
        return new Iphone();
    }

    @Override
    public Pad createPad() {
        return new IpadPro();
    }
}

class SamsungFactory extends AbstractDigitsFactory {
    @Override
    public void sayBranch() {
        System.out.println("SamSung.Corp");
    }

    @Override
    public SmartPhone createSmartPhone() {
        return new GalaxyS9();
    }

    @Override
    public Pad createPad() {
        return new SamsungPad();
    }
}
class HuaweiFactory extends AbstractDigitsFactory {

    @Override
    public void sayBranch() {
        System.out.println("Huawei.Company");
    }

    @Override
    public SmartPhone createSmartPhone() {
        return new Nova2();
    }

    @Override
    public Pad createPad() {
        return new HuaweiPad();
    }
}
class Shop {
    public static void main(String[] args) {
        System.out.println("--------商店找苹果工厂拿货物-------");
        AbstractDigitsFactory appleFactory = new AppleFactory();
        appleFactory.createSmartPhone().sayName();
        appleFactory.createPad().sayName();
        appleFactory.sayBranch();
        System.out.println("--------商店找三星工厂拿货--------");
        AbstractDigitsFactory samsungFactory = new SamsungFactory();
        samsungFactory.createSmartPhone().sayName();
        samsungFactory.createPad().sayName();
        samsungFactory.sayBranch();
        /** 如果现在增加了一中品牌 */
        System.out.println("--------商店找华为工厂拿货--------");
        AbstractDigitsFactory huaweiFactory = new HuaweiFactory();
        huaweiFactory.createSmartPhone().sayName();
        huaweiFactory.createPad().sayName();
        huaweiFactory.sayBranch();
    }
}
