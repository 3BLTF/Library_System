import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Frame extends JFrame implements ActionListener {
    private JTextField textField;
    private int capacity;

    public Frame() {
        setTitle("Library Application");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("ProgramIcon.png");
        setIconImage(icon.getImage());

        ImageIcon backGround1 = new ImageIcon("BackGround1.png");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();

        JLabel label1 = new JLabel();
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label1.setText("Enter the capacity of your library");
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 30));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        label1.setIcon(backGround1);

        panel1.add(label1, BorderLayout.CENTER);

        panel2.setLayout(new FlowLayout());
        panel2.add(textField);
        panel2.add(submitButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    public Frame(int capacity) {
        Library lib = new Library(capacity);
        this.capacity = capacity;
        setTitle("Library Application");
        setSize(1000, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("ProgramIcon.png");
        setIconImage(icon.getImage());

        ImageIcon backGround1 = new ImageIcon("BackGround1.png");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());

        JPanel panel2 = new JPanel();

        JLabel label1 = new JLabel();
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setHorizontalAlignment(JLabel.CENTER);

        label1.setText("Library capacity: " + capacity);
        label1.setFont(new Font("MV Boli", Font.PLAIN, 20));
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.addBook();
            }
        });

        JButton removeButton = new JButton("Remove Book");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.removeBook();
            }
        });

        JButton borrowingButton = new JButton("Borrowing Book");
        borrowingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.borrowBook();
            }
        });

        JButton returningButton = new JButton("Returning Book");
        returningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.returnBook();
            }
        });

        JButton statusButton = new JButton("View the library status");
        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lib.viewLibraryStatus();
            }
        });

        label1.setIcon(backGround1);

        panel1.add(label1, BorderLayout.CENTER);

        panel2.setLayout(new FlowLayout());
        panel2.add(addButton);
        panel2.add(removeButton);
        panel2.add(borrowingButton);
        panel2.add(returningButton);
        panel2.add(statusButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel1, BorderLayout.CENTER);
        mainPanel.add(panel2, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            String capacityText = textField.getText();
            try {
                capacity = Integer.parseInt(capacityText);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid capacity input: " + capacityText);
            }
        }
        dispose();
        new Frame(capacity);
    }

    public static void main(String[] args) {
        new Frame();
    }
}