package Register;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 组合模式
 * 一般用来表示具有层次结构关系的类,比如AWT中就使用了组合模式,BUTTON,VIEW等等。
 * 叶子节点继承的方法如果不需要的话要以为空处理和异常的方式来告诉用户。
 */
interface Component {
    void sayName();

    void add(Component component);

    void remove(int key);
}

class Button implements Component {
    private final static String name = "BUTTON";

    @Override
    public void sayName() {
        System.out.println(name);
    }

    @Override
    public void add(Component component) {
        throw new RuntimeException("组建不支持该方法");
    }

    @Override
    public void remove(int index) {
        throw new RuntimeException("组建不支持该方法");
    }
}

class Div implements Component {
    private final static String name = "DIV";
    private List<Component> components = new ArrayList<>();

    @Override
    public void sayName() {
        System.out.println(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(int index) {
        components.remove(index);
    }

    public List<Component> getComponents() {
        return components;
    }
}

class HTML {
    public static void main(String[] args) {
        Div div = new Div();
        div.add(new Div());
        div.add(new Button());
        for (Component component : div.getComponents()) {
            component.sayName();
            if (component instanceof Div) {
                component.add(new Button());
            }
        }
    }
}
