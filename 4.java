import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.Naming;

public class ClientGUI {

    private StringAnalyzer analyzer;

    public ClientGUI() {
        try {
            analyzer = (StringAnalyzer) Naming.lookup("rmi://localhost/StringService");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failed");
            return;
        }

        JFrame frame = new JFrame("Remote String Analyzer");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JTextField inputField = new JTextField(20);
        JButton palindromeBtn = new JButton("Check Palindrome");
        JButton reverseBtn = new JButton("Reverse String");
        JButton numberPalindromeBtn = new JButton("Number Palindrome");
        JTextArea resultArea = new JTextArea(5, 30);

        frame.add(new JLabel("Enter Input:"));
        frame.add(inputField);
        frame.add(palindromeBtn);
        frame.add(reverseBtn);
        frame.add(numberPalindromeBtn);
        frame.add(resultArea);

        palindromeBtn.addActionListener(e -> {
            try {
                boolean result = analyzer.isPalindrome(inputField.getText());
                resultArea.setText("Palindrome: " + result);
            } catch (Exception ex) {
                resultArea.setText("Error occurred");
            }
        });

        reverseBtn.addActionListener(e -> {
            try {
                String result = analyzer.reverseString(inputField.getText());
                resultArea.setText("Reversed: " + result);
            } catch (Exception ex) {
                resultArea.setText("Error occurred");
            }
        });

        numberPalindromeBtn.addActionListener(e -> {
            try {
                int number = Integer.parseInt(inputField.getText());
                boolean result = analyzer.isNumberPalindrome(number);
                resultArea.setText("Number Palindrome: " + result);
            } catch (NumberFormatException ex) {
                resultArea.setText("Enter a valid number");
            } catch (Exception ex) {
                resultArea.setText("Error occurred");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ClientGUI();
    }
}

