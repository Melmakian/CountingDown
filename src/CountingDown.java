public class CountingDown {
    public static volatile int countSeconds = 6;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();

        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        @Override
        public void run() {
            try {
                while (countSeconds > 0){
                    System.out.println(countSeconds +" ");
                    countSeconds--;
                    Thread.sleep(1000);
                }
                if (countSeconds==0)
                    System.out.println("March!");
            }catch (InterruptedException e){
                if (countSeconds >=0)
                    System.out.println("interrupted");
            }
        }
    }
}
