package Register;

import java.util.Arrays;

/**
 * Created by lanyage on 2018/5/22.
 */

/**
 * 策略模式
 * 将行为抽取出去封装成为策略类,这样的话将策略对象作为参数传给行为类的方法
 */
public class ArraySort {
    public void sort(SortStrategy sort, int[] a) {
        sort.sort(a);
    }

    public static void main(String[] args) {
        ArraySort sort = new ArraySort();
        sort.sort(new BubbleSort(), new int[]{3, 2, 1});
    }
}

interface SortStrategy {
    void sort(int[] a);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] a) {
        System.out.println("------bubble sort------");
        int r = a.length;
        while ((r = bubble(a, r)) > 1) ;
        System.out.println(Arrays.toString(a));
    }

    private int bubble(int[] a, int r) {
        int last = r - 1;
        for (int i = 0; i < r - 1; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                last = i + 1;
            }
        }
        return last;
    }
}
