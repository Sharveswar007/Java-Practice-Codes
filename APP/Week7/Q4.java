public class Q4 {
    static class HelloThread extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello " + i);
            }
        }
    }
    
    static class WelcomeThread extends Thread {
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Welcome " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        new HelloThread().start();
        new WelcomeThread().start();
    }
}
