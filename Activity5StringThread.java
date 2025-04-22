class Activity5StringThread implements Runnable {

    @Override
    public void run() {
        // Print words ["One", "Two", "Three", "Four", "Five"], pausing 4 seconds between each
        String[] words = {"One", "Two", "Three", "Four", "Five"};
        for (String word : words) {
            System.out.println(word);
            try {
                Thread.sleep(4000);  // 4-second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Two Exiting");
    }
}
