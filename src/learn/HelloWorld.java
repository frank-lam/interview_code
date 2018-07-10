package learn;

/**
 * @author Created By Frank
 * @date 2018-07-09 23:05
 */
public class HelloWorld {
    public static void main(String[] args){
        Class cls = String.class;
        System.out.println(cls.getName());
        System.out.println(cls.getSimpleName());
        System.out.println(cls.isLocalClass());
    }
}
