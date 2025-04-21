/*import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;

    public Client() {
        initializeGUI();
        connectToServer();
    }

    private void initializeGUI() {
        frame = new JFrame("Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void connectToServer() {
        new Thread(() -> {
            try {
                socket = new Socket("localhost", 1234);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                appendToChat("Connected to server. Type 'bye' to exit.");

                String response;
                while ((response = in.readLine()) != null) {
                    appendToChat("Server: " + response);
                }

                closeConnection();
                appendToChat("Disconnected from server.");
                System.exit(0);
            } catch (IOException e) {
                appendToChat("Connection error: " + e.getMessage());
            }
        }).start();
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            appendToChat("Client: " + message);
            inputField.setText("");
            
            if ("bye".equalsIgnoreCase(message)) {
                frame.dispose();
            }
        }
    }

    private void appendToChat(String message) {
        SwingUtilities.invokeLater(() -> chatArea.append(message + "\n"));
    }

    private void closeConnection() throws IOException {
        if (out != null) out.close();
        if (in != null) in.close();
        if (socket != null) socket.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Client::new);
    }
}*/

import javax.swing.JPanel;
import javax.swing.JButton;

public class Main {
    
    JPanel panel = new JPanel(); // Uses FlowLayout by default

    public Main() {
        panel.add(new JButton("C++"));
        panel.add(new JButton("Python"));
        panel.add(new JButton("Java"));
    }
}
//IS just for test !
