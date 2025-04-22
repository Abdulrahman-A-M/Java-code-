class Activity5Thread implements Runnable {

    @Override
    public void run() {
        // Print numbers 1 to 5, pausing 4 seconds between each
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(4000);  // 4-second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("One Exiting");
    }
}
