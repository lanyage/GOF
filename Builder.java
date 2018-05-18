package Register;

/**
 * Created by lanyage on 2018/5/18.
 * 建造者模式
 * 定义:主要是将对象的表示和建造分离，一般用于创建复杂的对象
 * 要素:
 * 1.产品类,一般是复杂的对象,也就是创建对象的过程比较复杂
 * 2.建造者接口,一般提供抽象的建造对象的方法和获取对象的方法
 * 3.建造者,建造者接口的实现类,用于组建产品对象和返回产品对象
 * 4.导演类,负责调用适当的建造者来组建产品,一般不直接和产品交互,一般封装易变的部分
 */

/**
 * 产品类
 */
class Product {
    private String name;
    private String catagory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }
}

/**
 * 建造者接口
 */
interface IProductBuilder {
    IProductBuilder name(String name);

    IProductBuilder catagory(String catagory);

    Product build();
}

/**
 * 具体建造者接口
 */
class ProductBuilder implements IProductBuilder {
    private Product product = new Product();

    @Override
    public IProductBuilder name(String name) {
        product.setName(name);
        return this;
    }

    @Override
    public IProductBuilder catagory(String catagory) {
        product.setCatagory(catagory);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }
}

/**
 * 导演类
 */
class Director {
    private IProductBuilder builder = new ProductBuilder();

    public Product getBMW() {
        return builder.name("BMW").catagory("Car").build();
    }

    /**
     * ......
     * ......
     * ......
     * //////////////////////
     * //还可以构建很多种类的产品
     * //////////////////////
     */
    public Product getBenzi() {
        return builder.name("Benzi").catagory("Car").build();
    }
}

class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Product bmw = director.getBMW();
        System.out.println(bmw.getName());
        System.out.println(bmw.getCatagory());
        System.out.println(bmw.getClass());
        System.out.println("-----------------------");
        Product benzi = director.getBenzi();
        System.out.println(benzi.getName());
        System.out.println(benzi.getCatagory());
        System.out.println(benzi.getClass());
    }
}

