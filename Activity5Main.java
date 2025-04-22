public class Activity5Main {

    public static void main(String[] args) {

        // Create two Thread objects (both are Runnables)
        Thread t1 = new Thread(new Activity5Thread());       // Prints 1..5
        Thread t2 = new Thread(new Activity5StringThread()); // Prints One..Five

        // Start both threads
        t1.start();
        t2.start();

        // Main does not wait for threads to finish
        System.out.println("Main won't wait. Main exits.");
    }
}
