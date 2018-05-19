package Register;

/**
 * Created by lanyage on 2018/5/19.
 */

/**
 * 门面模式:旨在为客户端提供简单的接口
 * <p>
 * 门面模式旨在提供简单的接口,避免用户直接和复杂的底部类进行沟通
 */
class TeachersOffice {
    public void operate(String name) {
        System.out.println("班主任进行签字:同意" + name + "入学");
    }
}

class DiciplinesOffice {
    public void operate(String name) {
        System.out.println("校长进行签字:同意" + name + "入学");
    }
}

class MonetoryDepartment {
    public void operate(String name) {
        System.out.println("财务部为" + name + "盖章");
    }
}

class Recipient {
    public void register(String name) {
        new MonetoryDepartment().operate(name);
        new TeachersOffice().operate(name);
        new DiciplinesOffice().operate(name);
    }
}

class NewStudent {
    public static void main(String[] args) {
        Recipient recipient = new Recipient();
        recipient.register("张三");
    }
}
