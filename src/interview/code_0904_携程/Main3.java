package interview.code_0904_携程;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Main3 {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new BufferedReader(new FileReader("D:\\gitdoc\\interview_code\\src\\interview\\code_0904_携程\\input3.txt")));
        int cacheSize = in.nextInt();
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        LinkedList<Integer> useList = new LinkedList<>();
        ArrayList<Integer> printList = new ArrayList<>();
        in.nextLine();


        while (in.hasNext()) {
            String line = in.nextLine();
            String[] arr = line.split(" ");
            String op = arr[0];
            int key = Integer.valueOf(arr[1]);
            int value;

            // 插入操作
            if (op.equals("p")) {
                value = Integer.valueOf(arr[2]);
                if (hashMap.containsKey(key)) {
//                    System.out.println("put key : "+ key+"  value:" + value);
                    hashMap.put(key, value);
                } else { // 不包含的情况下
                    if (hashMap.size() >= cacheSize) { // 已经满的情况下，需要做一个更新
                        int rkey = getRemoveKey(hashMap, useList);
                        hashMap.remove(rkey);
                    }
//                    System.out.println("put key : "+ key+"  value:" + value);
                    hashMap.put(key, value);
                }
            }

            if (op.equals("g")) {
                if(useList.contains(key)){
                    for (int i = 0; i < useList.size(); i++) {
                        if(useList.get(i) == key){
                            useList.remove(i);
                            break;
                        }
                    }
                }
                useList.addLast(key);
                int v = -1;
                if (!hashMap.containsKey(key)) {
                    v = -1;
                } else {
                    v = hashMap.get(key);
                }
                printList.add(v);
            }

        }
        for (int i = 0; i < printList.size(); i++) {
            if (i != printList.size() - 1) {
                System.out.println(printList.get(i));
            } else {
                System.out.print(printList.get(i));
            }
        }

    }

    private static int getRemoveKey(TreeMap<Integer, Integer> hashMap, LinkedList<Integer> useList) {
        if (useList.isEmpty()) {
            int count = 0;
            int rkey = 0;
            for (int k : hashMap.keySet()) {
                if (count == 0) {
                    rkey = k;
                }
                count++;
            }
            return rkey;
        }

        int key = -22012;
        for (int k : hashMap.keySet()) {
            if (!useList.contains(k)) {
                key = k;
                break;
            }
        }
        if (key != -22012) {
            return key;
        } else {
            if (!useList.isEmpty()) {
                return useList.removeFirst();
            }
        }
        return -1;

//        return key;
    }

}
