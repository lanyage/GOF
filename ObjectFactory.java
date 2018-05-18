package Register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by lanyage on 2018/5/18.
 */

/**
 * 对象工厂,根据类类型来获取构造器,可以是默认构造器和非默认构造器
 * 然后根据不同的参数类类型的数组,参数的可变参数,通过反射来构建对象
 */
class Demo {
    private String name;

    public Demo() {
    }

    public Demo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ObjectFactory {
    <T> T create(Class<T> clazz) {
        return create(clazz, null, null);
    }

    <T> T create(Class<T> clazz, Class<?>[] parameterTypes, Object... parameters) {
        T t = null;
        try {
            Constructor<T> constructor;
            if (parameters == null && parameters == null) {
                constructor = clazz.getDeclaredConstructor(parameterTypes);
                if (!constructor.isAccessible())
                    constructor.setAccessible(true);
                t = constructor.newInstance(new Object[0]);
            } else {
                constructor = clazz.getDeclaredConstructor(parameterTypes);
                if (!constructor.isAccessible())
                    constructor.setAccessible(true);
                t = constructor.newInstance(parameters);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    public static void main(String[] args) {
        ObjectFactory objectFactory = new ObjectFactory();
        Demo demo = objectFactory.create(Demo.class,new Class[]{String.class},"Hello world22");
        System.out.println(demo.getName());
    }
}
