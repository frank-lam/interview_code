package interview.code_0911_百度;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {

    public static void main(String[] args) throws FileNotFoundException {

    }

    List<Integer> findCommonElements(int numCustomer, int numProduct, List<List<Integer>> productList) {
        List<Integer> reslist = new ArrayList<>();
        for (int i = 0; i < numCustomer; i++) {
            List<Integer> list = new ArrayList<>();
            list = productList.get(i);
            for (int k = 0; k < numProduct; k++) {
                int item = list.get(k);

                int count = 0;
                for (int j = 0; j < numCustomer; j++) {
                    List<Integer> otherList = new ArrayList<>();
                    otherList = productList.get(j);
                    if (j != i) {
                        if (otherList.contains(item)) {
                            count++;
                        }
                    }
                }
                if (count == numCustomer - 1) {
                    if (!reslist.contains(item)) {
                        reslist.add(item);
                    }
                }
            }
        }
        Collections.sort(reslist);


        return reslist;
    }

}
