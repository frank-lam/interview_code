package learn;

/**
 * @author Created By Frank
 * @date 2018-07-09 17:38
 */


class AddThread extends Thread{
    public void run(){
        for(int i =0;i<Main.LOOP;i++ ){
            Main.count ++;
        }
    }
}

class DecThread extends Thread{
    public void run(){
        for(int i =0;i<Main.LOOP;i++){
            Main.count--;
        }
    }
}


public class Main {
    final static int LOOP = 1000000;
    public static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new AddThread();
        Thread t2 = new DecThread();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }


}
