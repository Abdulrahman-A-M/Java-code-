import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UniversityCourseRegistrationFrame extends JFrame {
    // Components for student info
    private JLabel lblName;
    private JTextField txtName;
    private JLabel lblID;
    private JTextField txtID;
    private JLabel lblMajor;
    private JComboBox<String> cmbMajor;
    
 
    private JLabel lblCourse;
    private JComboBox<String> cmbCourse;  
    private JTextArea txtSchedule;
    private JCheckBox chkAudit; 

    private JButton btnSubmit;
    
 
    private JLabel lblLogo;
    
    public UniversityCourseRegistrationFrame() {
        // Set frame title as the university name
        super("King Saud University Course Registration");
        
        // Set layout and color scheme
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(230, 240, 255)); 
        
      
        JPanel pnlLogo = new JPanel();
        pnlLogo.setBackground(new Color(230, 240, 255));
        
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\ssrt4\\Desktop\\logo_kku.png");
        lblLogo = new JLabel(logoIcon);
        pnlLogo.add(lblLogo);
        add(pnlLogo, BorderLayout.NORTH);
        
        JPanel pnlForm = new JPanel();
        pnlForm.setLayout(new GridBagLayout());
        pnlForm.setBackground(new Color(230, 240, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // margins
        
        lblName = new JLabel("Student Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlForm.add(lblName, gbc);
        
        txtName = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlForm.add(txtName, gbc);
        
        lblID = new JLabel("Student ID:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlForm.add(lblID, gbc);
        
        txtID = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlForm.add(txtID, gbc);
        
        lblMajor = new JLabel("Major:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlForm.add(lblMajor, gbc);
        
        String[] majors = {"Computer Science", "Engineering", "Business", "Architecture"};
        cmbMajor = new JComboBox<>(majors);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlForm.add(cmbMajor, gbc);
        
        // Row 3 - Course Selection
        lblCourse = new JLabel("Select Course:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LINE_END;
        pnlForm.add(lblCourse, gbc);
        
        cmbCourse = new JComboBox<>();
        cmbCourse.addItem("Loading courses...");
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlForm.add(cmbCourse, gbc);
        
        cmbCourse.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String course = (String)cmbCourse.getSelectedItem();
                    txtSchedule.setText("Schedule for " + course + ":\nMon, Wed, Fri: 10:00 AM - 11:30 AM");
                }
            }
        });
        
        txtSchedule = new JTextArea(4, 20);
        txtSchedule.setEditable(false);
        txtSchedule.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        pnlForm.add(new JScrollPane(txtSchedule), gbc);
        gbc.gridwidth = 1; 
        
        chkAudit = new JCheckBox("Audit Course");
        chkAudit.setBackground(new Color(230, 240, 255));
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.LINE_START;
        pnlForm.add(chkAudit, gbc);
        
        add(pnlForm, BorderLayout.CENTER);
        
        JPanel pnlSubmit = new JPanel();
        pnlSubmit.setBackground(new Color(230, 240, 255));
        btnSubmit = new JButton("Submit Registration");
        pnlSubmit.add(btnSubmit);
        add(pnlSubmit, BorderLayout.SOUTH);
        
     
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String id = txtID.getText();
                String major = (String) cmbMajor.getSelectedItem();
                String course = (String) cmbCourse.getSelectedItem();
                boolean audit = chkAudit.isSelected();
                
                
                JOptionPane.showMessageDialog(UniversityCourseRegistrationFrame.this,
                        "Registration Submitted:\nName: " + name +
                        "\nID: " + id +
                        "\nMajor: " + major +
                        "\nCourse: " + course +
                        "\nAudit: " + (audit ? "Yes" : "No"),
                        "Registration", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  
        

        new Thread(new Runnable() {
            @Override
            public void run() {
            
                try {
                    Thread.sleep(2000); // wait for 2 seconds
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                // Courses loaded dynamically
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        cmbCourse.removeAllItems();
                        cmbCourse.addItem("CS101 - Intro to Computer Science");
                        cmbCourse.addItem("ENG202 - Cybersecurity");
                        cmbCourse.addItem("BUS303 - Marketing Management");
                        cmbCourse.addItem("ARC404 - Programming");
                    }
                });
            }
        }).start();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UniversityCourseRegistrationFrame().setVisible(true);
            }
        });
    }
}
