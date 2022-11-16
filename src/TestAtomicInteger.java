import java.util.concurrent.atomic.AtomicInteger;

class Thread1 implements Runnable
{
    // without Atomic variable there is a problem with the reult
    // the result is not consistent

   /* int a = 0;
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            a++;
        }
    }

    public int getA()
    {
        return a;
    } */

    // using Atomic variables to resolve the problem
    // this supports lock-free thread-safe programming on single variables.
    AtomicInteger count = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count.incrementAndGet();
        }
    }

    public int getCount()
    {
        return count.get();
    }
}
public class TestAtomicInteger {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(t.getCount());

    }
}
