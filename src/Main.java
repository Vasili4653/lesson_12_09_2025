import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //3.536 sec
        Date now = new Date();
        // создаем 2 потока
        // 1.79 sec
        Thread t1 = new Thread(() -> calc(0, 100000000 / 2));
        Thread t2 = new Thread(() -> calc(100000000 / 2, 100000000));
        t1.start();
        t2.start();
        t1.join();//выравниваем время ожидания с нулевым потоком
        t2.join();
        System.out.println(new Date().getTime() - now.getTime());
        System.out.println(t1.getName());
        System.out.println(Thread.currentThread().getName());
        System.out.println(t2.getState());
        Counter c = new Counter();

        t1 = new Thread(() -> {
            for(int i = 0; i < 1000000; i++){
                c.value++;
            }
        });
        t2 = new Thread(() -> {
            for(int i = 0; i < 1000000; i++){
                c.value--;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.value);
    }

    public static void calc(int from, int to){
        for(int i = from; i < to; i++){
            double d = Math.asin(85 * i) + Math.acos(3*i) / Math.atan(1221d / i);
        }
    }
}