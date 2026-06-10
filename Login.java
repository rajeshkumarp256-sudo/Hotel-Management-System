import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    // Components declare karein taaki actionPerformed mein use ho sakein
    JLabel l1, l2, heading;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    public Login() {
        // Window ka Title
        super("Hotel Taj Group - Secure Login");
        
        setLayout(null);
        // Light grey background jo aankhon ko sukoon de
        getContentPane().setBackground(new Color(245, 245, 245)); 

        // --- HEADING KO CENTER MEIN LANE KE LIYE BOUNDS ---
        heading = new JLabel("LOGIN");
        heading.setBounds(190, 20, 100, 30); // Width 500 ke hisab se center (450 window width par)
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        add(heading);

        // --- COMPONENTS KO BICH MEIN LANE KE LIYE BOUNDS ---
        
        l1 = new JLabel("Username:");
        l1.setBounds(80, 80, 100, 30); // 80 se start kiya taaki bich mein dikhe
        l1.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(200, 80, 180, 30); // Labels ke bagal mein sahi alignment
        add(t1);

        l2 = new JLabel("Password:");
        l2.setBounds(80, 140, 100, 30);
        l2.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(l2);

        t2 = new JPasswordField();
        t2.setBounds(200, 140, 180, 30);
        add(t2);

        // --- BUTTONS KO BICH MEIN LANE KE LIYE BOUNDS ---
        
        b1 = new JButton("Login");
        b1.setBounds(80, 220, 130, 35);
        b1.setBackground(new Color(0, 102, 204)); // Royal Blue color
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.BOLD, 14));
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(250, 220, 130, 35); // 250 se start symmetrical look ke liye
        b2.setBackground(new Color(204, 0, 0)); // Professional Red
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Tahoma", Font.BOLD, 14));
        b2.addActionListener(this);
        add(b2);

        // --- CENTER MEIN LAANE KE LIYE YE SEQUENCE SABSE ZAROORI HAI ---
        
        setSize(500, 350);              // 1. Pehle Window ka size decide kiya
        setLocationRelativeTo(null);     // 2. Ab Screen ke center mein set kiya
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);                // 3. Sabse aakhri mein display kiya
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String user = t1.getText();
            String pass = new String(t2.getPassword());

            // Simple Security Check
            if (user.equals("admin") && pass.equals("12345")) {
                new Dashboard().setVisible(true); // Dashboard open hoga
                this.dispose(); // Login window band ho jayegi
            } else {
                JOptionPane.showMessageDialog(null, "Galat ID या Password है!");
            }
        } else if (ae.getSource() == b2) {
            System.exit(0); // Program band karne ke liye
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}