package firstchapter;

public class RunnableAnonymous {
    public static void main(String args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Something");
            }
        }).start();
    }
}
