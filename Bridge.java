package Register;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 桥模式是为了实现抽象和实现的解耦
 * <p>
 * 抽象类和实现类之间的扩展不会影响彼此,抽象和实现之间是弱关联的组合关系
 */
interface Shape {
    String getName();
}

class Square implements Shape {
    private static final String name = "Square";

    @Override
    public String getName() {
        return name;
    }
}

class Circle implements Shape {
    private static final String name = "Circle";

    @Override
    public String getName() {
        return name;
    }
}

abstract class pen {
    public abstract String draw(Shape shape);
}

class BrushPen extends pen {
    @Override
    public String draw(Shape shape) {
        return "Brush pen draw " + shape.getName();
    }
}

class DotPen extends pen {
    @Override
    public String draw(Shape shape) {
        return "Dot pen draw " + shape.getName();
    }
}

class Drawer {
    public static void main(String[] args) {
        /** 可以非常方便的扩展 形状和笔类型,彼此之间的扩展不会影响对方 */
        BrushPen brushPen = new BrushPen();
        System.out.println(brushPen.draw(new Square()));
        System.out.println(brushPen.draw(new Circle()));
        DotPen dotPen = new DotPen();
        System.out.println(dotPen.draw(new Square()));
        System.out.println(dotPen.draw(new Circle()));
    }
}
