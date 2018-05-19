package Register;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 代理模式:顾名思义
 * 代理模式分为静态代理和动态代理,动态代理则将代理的思想提升了一个层次,分为两种动态代理,一种是基于asm的还有一种是基于cglib的,前者面向接口变成,后者则使用继承的思想
 */
interface Subject {
    String repeat(String name);
}

class RealSubject implements Subject {
    @Override
    public String repeat(String name) {
        return name;
    }
}

class SubjectDelegator implements Subject {
    private Subject subject;

    public SubjectDelegator(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String repeat(String name) {
        return subject.repeat(name);
    }
}

class ProxyDemo {
    public static void main(String[] args) {
        //////////////////////////////////
        //动态代理
        /////////////////////////////////
        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class<?>[]{Subject.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("repeat")) {
                    return args[0];
                }
                return null;
            }
        });
        String str = subject.repeat("Hello World");
        System.out.println(str);
        System.out.println("---------------------------------");
        /////////////////////////////////
        //静态代理
        /////////////////////////////////
        Subject realObj = new RealSubject();
        Subject subject1 = new SubjectDelegator(realObj);
        System.out.println(subject1.repeat("Hello World2"));
    }
}
