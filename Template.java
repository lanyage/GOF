package Register;

/**
 * Created by lanyage on 2018/5/22.
 */
abstract class CookDrink {
    public final void cook(int mins, String name) {
        boilWater();
        waita(mins);
        put(name);
        drink();
    }

    private void boilWater() {
        System.out.println("boil water,first.");
    }

    protected abstract void waita(int mins);

    protected abstract void put(String name);

    private void drink() {
        System.out.println("ok, now you can drink." + getClass().getSimpleName());
    }
}

class CookTea extends CookDrink {
    @Override
    protected void waita(int mins) {
        System.out.println("cause you are cook tea, you have to wait a little bit about " + mins + " mins.");
    }

    @Override
    protected void put(String name) {
        System.out.println("now it is time for you to put " + name + " into the boiled water.");
    }
}

class CookCoffee extends CookDrink {

    @Override
    protected void waita(int mins) {
        System.out.println("cooking coffee takes some time. about " + mins + " mins.");
    }

    @Override
    protected void put(String name) {
        System.out.println("alright, put the " + name + " into the boiled water.");
    }
}

class Client {
    public static void main(String[] args) {
        CookDrink cookTea = new CookTea();
        cookTea.cook(5, "Tea");
        System.out.println("-----------------");
        CookDrink cookCofee = new CookCoffee();
        cookCofee.cook(20, "Coffee");
    }
}
