import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    public Dashboard() {
        // Full screen cover karne ke liye
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setLayout(null);
        
        // Background Color - Dark Navy Blue (Professional Look)
        getContentPane().setBackground(new Color(20, 33, 61)); 

        // --- ATTEMPT IMAGE LOADING ---
        try {
            // Path check: 'hotel.jpg' ya 'Hotel Project.jar' jo bhi aapki image hai
            ImageIcon i1 = new ImageIcon("C:\\Users\\MANISHA PATEL\\Desktop\\Hotel Project\\hotel.jpg");
            Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel image = new JLabel(i3);
            image.setBounds(0, 0, 1550, 1000);
            add(image);

            // Hotel Name - Shadow Effect and Golden Color
            JLabel text = new JLabel("THE HOTEL TAJ GROUP WELCOMES YOU");
            text.setBounds(250, 100, 1100, 80);
            text.setFont(new Font("Serif", Font.BOLD, 55));
            text.setForeground(new Color(252, 163, 17)); // Attractive Gold
            image.add(text);
            
        } catch (Exception e) {
            // Agar image nahi bhi aayi, toh ye text frame par sundar dikhega
            JLabel text = new JLabel("THE HOTEL TAJ GROUP WELCOMES YOU");
            text.setBounds(250, 100, 1100, 80);
            text.setFont(new Font("Serif", Font.BOLD, 55));
            text.setForeground(new Color(252, 163, 17));
            add(text);
        }

        // --- MENU BAR (ALL OLD ITEMS KE SAATH) ---
        JMenuBar mb = new JMenuBar();
        mb.setBackground(Color.WHITE);
        mb.setPreferredSize(new Dimension(1600, 50));
        setJMenuBar(mb);

        // 1. Hotel Management
        JMenu hotel = new JMenu("  HOTEL MANAGEMENT  ");
        hotel.setFont(new Font("Tahoma", Font.BOLD, 14));
        hotel.setForeground(new Color(20, 33, 61));
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

        // 2. Admin Menu (Attractive Red Color)
        JMenu admin = new JMenu("  ADMIN  ");
        admin.setFont(new Font("Tahoma", Font.BOLD, 14));
        admin.setForeground(new Color(214, 40, 40)); 
        mb.add(admin);

        // Saare purane items ek saath add kiye hain
        String[] menuItems = {"ADD CUSTOMER", "VIEW CUSTOMERS", "BILLING", "VIEW BILLING"};
        for(String s : menuItems) {
            JMenuItem mi = new JMenuItem(s);
            mi.addActionListener(this);
            admin.add(mi);
        }

        // 3. System Menu
        JMenu system = new JMenu("  SYSTEM  ");
        system.setFont(new Font("Tahoma", Font.BOLD, 14));
        mb.add(system);
        JMenuItem exit = new JMenuItem("EXIT");
        exit.addActionListener(this);
        system.add(exit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();

        if (msg.equals("RECEPTION")) new Reception().setVisible(true);
        else if (msg.equals("ADD CUSTOMER")) new AddCustomer().setVisible(true);
        else if (msg.equals("VIEW CUSTOMERS")) new ViewCustomer().setVisible(true);
        else if (msg.equals("BILLING")) new Billing().setVisible(true);
        else if (msg.equals("VIEW BILLING")) new ViewBilling().setVisible(true);
        else if (msg.equals("EXIT")) System.exit(0);
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}