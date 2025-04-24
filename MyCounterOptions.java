import javax.swing.*;

public class MyCounterOptions extends JFrame {
    private JTextField counterField;
    private JRadioButton upRadio;
    private JRadioButton downRadio;
    private JComboBox<Integer> stepCombo;
    private int counter = 0;

    public MyCounterOptions() {
        setTitle("Swing Counter with RadioButton & ComboBox");

        
        counterField = new JTextField("0", 5);
        counterField.setEditable(false);

        
        upRadio = new JRadioButton("Up", true);
        downRadio = new JRadioButton("Down");
        ButtonGroup directionGroup = new ButtonGroup();
        directionGroup.add(upRadio);
        directionGroup.add(downRadio);


        stepCombo = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});


        JButton countButton = new JButton("Count");
        countButton.addActionListener(e -> updateCounter());

        JPanel mainPanel = new JPanel();
        mainPanel.add(new JLabel("Counter:"));
        mainPanel.add(counterField);
        mainPanel.add(upRadio);
        mainPanel.add(downRadio);
        mainPanel.add(new JLabel("Step:"));
        mainPanel.add(stepCombo);
        mainPanel.add(countButton);

        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void updateCounter() {
        int step = (Integer) stepCombo.getSelectedItem();
        if (upRadio.isSelected()) {
            counter += step;
        } else {
            counter -= step;
        }
        counterField.setText(String.valueOf(counter));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyCounterOptions());
    }

    public JTextField getCounterField() {
        return counterField;
    }
}