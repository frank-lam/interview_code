package learn;

import java.util.StringTokenizer;

/**
 * @author Created By Frank
 * @date 2018-07-06 11:14
 */



public class trie_learn {
    public static void main(String[] args){

        StringTokenizer st = new StringTokenizer("I am from Hangzhou");
        while(st.hasMoreTokens()){
            System.out.println(st.countTokens());
        }

    }
}
