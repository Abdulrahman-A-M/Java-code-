import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private JFrame frame;
    private JTextArea chatArea;
    private JTextField inputField;

    public Server() {
        initializeGUI();
        startServer();
    }

    private void initializeGUI() {
        frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputField = new JTextField();
        inputField.setEnabled(false);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(e -> sendMessage());

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void startServer() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(1234);
                appendToChat("Server started. Waiting for client...");
                
                while (true) {
                    clientSocket = serverSocket.accept();
                    appendToChat("Client connected: " + clientSocket.getInetAddress());
                    
                    out = new PrintWriter(clientSocket.getOutputStream(), true);
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    inputField.setEnabled(true);

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        appendToChat("Client: " + inputLine);
                        if ("bye".equalsIgnoreCase(inputLine)) {
                            break;
                        }
                    }

                    closeConnection();
                    appendToChat("Client disconnected. Waiting for new connection...");
                }
            } catch (IOException e) {
                appendToChat("Server error: " + e.getMessage());
            }
        }).start();
    }

    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            appendToChat("Server: " + message);
            inputField.setText("");
        }
    }

    private void appendToChat(String message) {
        SwingUtilities.invokeLater(() -> chatArea.append(message + "\n"));
    }

    private void closeConnection() throws IOException {
        if (out != null) out.close();
        if (in != null) in.close();
        if (clientSocket != null) clientSocket.close();
        inputField.setEnabled(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Server::new);
    }
}