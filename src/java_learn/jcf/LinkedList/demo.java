package java_learn.jcf.LinkedList;

import java.util.LinkedList;

/**
 * @author Created By Frank
 * @date 2018-07-14 10:25
 */
public class demo {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        list.addLast(20);

        System.out.println(list);

    }
}
