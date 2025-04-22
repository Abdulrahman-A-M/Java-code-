import javax.swing.JPanel;

public class test {
    
    JPanel panel = new JPanel(); // Uses FlowLayout by default

    public Main() {
        panel.add(new JButton("C++"));
        panel.add(new JButton("Python"));
        panel.add(new JButton("Java"));
    }
}
