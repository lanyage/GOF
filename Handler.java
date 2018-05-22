package Register;

/**
 * Created by lanyage on 2018/5/22.
 */

/**
 * 责任链模式
 * <p>
 * 类似于权限链,目的是使更多的请求被处理,如果链中一个handler不能处理请求会将请求传给更上层
 */
class Customer {
    private AbstractPriceHandler priceHandler;

    public Customer(AbstractPriceHandler priceHandler) {
        this.priceHandler = priceHandler;
    }

    public void request(double price) {
        priceHandler.handle(price);
    }
}

abstract class AbstractPriceHandler {
    protected AbstractPriceHandler successor;

    public abstract void handle(double price);
}

class Sale extends AbstractPriceHandler {
    private static final double MAX_PERMISSION = 0.05;

    public Sale(AbstractPriceHandler successor) {
        this.successor = successor;
    }

    @Override
    public void handle(double price) {
        if (price > MAX_PERMISSION) {
            successor.handle(price);
        } else {
            System.out.println(this.getClass().getSimpleName() + " handling the request of " + price);
        }
    }
}

class Manager extends AbstractPriceHandler {
    public void handle(double price) {
        System.out.println(this.getClass().getSimpleName() + " handling the request of " + price);
    }
}

class State {
    public static void main(String[] args) {
        AbstractPriceHandler sale = new Sale(new Manager());
        Customer customer = new Customer(sale);
        customer.request(0.6);
    }
}

