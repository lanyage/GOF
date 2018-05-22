package Register;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lanyage on 2018/5/22.
 */
public class MyList {
    private int[] data;
    private int size;

    public MyList(int[] a) {
        data = a;
        size = a.length;
    }

    public class Iterator {
        private int current = -1;

        public boolean hasNext() {
            return current < size - 1;
        }

        public int next() {
            if (hasNext()) {
                return data[++current];
            } else {
                throw new RuntimeException("No such element");
            }
        }
    }

    public Iterator iterator() {
        return new Iterator();
    }
}

class Main {
    public static void main(String[] args) {
        MyList list = new MyList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        MyList.Iterator iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
