
import javax.swing.*;
import java.awt.*;

public class MyLayoutActivity extends JFrame {

    public MyLayoutActivity() {
        // Set the title of the frame
        super("My Layout Activity");

        // Set the size of the frame
        setSize(400, 400);

        // Close the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Use BorderLayout as the layout manager
        setLayout(new BorderLayout());

        // Create a panel for the left section (West)
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.add(new JLabel("C++"));

        // Create a panel for the center section
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(new JLabel("Python"));

        // Create a panel for the right section (East)
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.add(new JLabel("Java"));

        // Add the panels to the frame using BorderLayout regions
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MyLayoutActivity::new);
    }
}
