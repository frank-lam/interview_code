package java_learn.concurrent.create_thread;

/**
 * @author Created By Frank
 * @date 2018-08-09 9:14
 */
public class Thread1 extends Thread {

    @Override
    public void run(){
        int i = 0;
        while(i<100){
            i++;
            System.out.println("hello frank");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("hello run");
    }

    public static void main(String[] args){
        Thread1 t1 = new Thread1();
        t1.start();
    }



}
