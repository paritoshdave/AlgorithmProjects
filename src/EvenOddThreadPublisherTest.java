import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Paritosh Dave on 9/20/2015.
 *
 * Two publisher threads publishing data to their respective queue and
 * consumer is bound to both of the queue, consumer reads data in consecutive fashion from both the publisher queue.
 */
public class EvenOddThreadPublisherTest {

    public static void main(String[] args)
    {
        EvenOddThreadPublisherTest main = new EvenOddThreadPublisherTest();

        BlockingQueue<String> queue_even = new ArrayBlockingQueue<String>(10);
        BlockingQueue<String> queue_odd = new ArrayBlockingQueue<String>(10);

        Thread producer1 = main.new Producer(2, queue_even);
        Thread producer2 = main.new Producer(1, queue_odd);
        Thread consumer = main.new Consumer("C", queue_even, queue_odd);

        producer1.start();
        producer2.start();
        consumer.start();
    }

    private class Producer extends Thread{

        private int start_index;
        private BlockingQueue<String> queue;
        Producer(int  start_index, BlockingQueue<String> queue)
        {
            super();
            this.start_index = start_index;
            this.queue = queue;
        }

        @Override
        public void run()
        {
            for(int i = start_index; i<= 50; i = i+2)
            {
                try {
                    queue.put(String.valueOf(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class Consumer extends Thread{

        private String name;
        private BlockingQueue<String> queue_even;
        private BlockingQueue<String> queue_odd;
        Consumer(String name, BlockingQueue<String> queue_even, BlockingQueue<String> queue_odd)
        {
            super();
            this.name = name;
            this.queue_even = queue_even;
            this.queue_odd = queue_odd;
        }

        @Override
        public void run()
        {
            int i = 0;
            while(true)
            {

                try {
                    if(i%2 != 0)
                    {
                        String data = queue_even.take();
                        System.out.println(data);
                    }
                    else
                    {
                        String data = queue_odd.take();
                        System.out.println(data);
                    }
                    ++i;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


