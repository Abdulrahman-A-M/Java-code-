import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JugglerAnimation extends JFrame {
    
    private JButton startButton, stopButton;
    private JLabel animationLabel;
    private Thread animationThread;
    private boolean running = false;
    
    // Array of ImageIcons to store frames of the animation
    private ImageIcon[] frames;
    private int currentFrame = 0;
    
    // Delay between frames (in milliseconds)
    private final int DELAY = 200;  // Adjust as needed
    
    public JugglerAnimation() {
        super("Juggler Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
        
        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        
        // Add buttons to the panel
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        
        // Create the label that will display the images
        animationLabel = new JLabel();
        animationLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Load images (example: frame0.png, frame1.png, ...)
        loadFrames();
        
        // Add action listeners to buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAnimation();
            }
        });
        
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAnimation();
            }
        });
        
        // Add components to the frame
        add(buttonPanel, BorderLayout.NORTH);
        add(animationLabel, BorderLayout.CENTER);
    }
    
    private void loadFrames() {
        // Suppose you have 5 frames: frame0.png, frame1.png, ..., frame4.png
        // Adjust numberOfFrames according to how many images you have
        int numberOfFrames = 5;  
        frames = new ImageIcon[numberOfFrames];
        
        for (int i = 0; i < numberOfFrames; i++) {
            // Ensure these images are in your project directory or adjust path accordingly
            frames[i] = new ImageIcon(getClass().getResource("/resources/frame" + i + "C:\\Users\\ssrt4\\Pictures\\Screenshots\\Screenshot 2025-04-07 104727.png"));

        }
    }
    
    private void startAnimation() {
        // If there's no thread running or the old thread has died, create a new one
        if (animationThread == null || !animationThread.isAlive()) {
            running = true;
            animationThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (running) {
                        // Update the label icon on the Event Dispatch Thread
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                animationLabel.setIcon(frames[currentFrame]);
                            }
                        });
                        
                        // Move to the next frame
                        currentFrame = (currentFrame + 1) % frames.length;
                        
                        // Sleep to control animation speed
                        try {
                            Thread.sleep(DELAY);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            });
            animationThread.start();
        }
    }
    
    private void stopAnimation() {
        running = false;
        // Optionally, you could join the thread to ensure it finishes:
        // if (animationThread != null) {
        //     try {
        //         animationThread.join();
        //     } catch (InterruptedException e) {
        //         Thread.currentThread().interrupt();
        //     }
        // }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JugglerAnimation().setVisible(true);
            }
        });
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public void setStopButton(JButton stopButton) {
        this.stopButton = stopButton;
    }

    public JLabel getAnimationLabel() {
        return animationLabel;
    }

    public void setAnimationLabel(JLabel animationLabel) {
        this.animationLabel = animationLabel;
    }
}
