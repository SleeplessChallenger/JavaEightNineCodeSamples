package firstchapter;

public class RunnableExample {
    public static void main(String args) {
        // first example
        Runnable r = () -> System.out.println("This is my runnable");
        new Thread(r).start();
    }
}
