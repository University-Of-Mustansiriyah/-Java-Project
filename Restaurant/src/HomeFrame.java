import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {

    int sidebarWidth = 250, isOpened = 250;
    Timer timer;
    boolean isclose = true;

    CardLayout cardLayout = new CardLayout();
    JPanel mainPanel = new JPanel(cardLayout);

    public HomeFrame() {

        JFrame f = new JFrame("Home Frame");
        Font font = new Font("Arial", Font.BOLD, 25);
        f.setForeground(Color.WHITE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);

        JPanel homePanel = new JPanel();
        StaffPanal staffPanel = new StaffPanal();
        TablesPanel tablesPanel = new TablesPanel();
        OrderPanel orderPanel=new OrderPanel();
        FoodPanel foodPanel = new FoodPanel();
        foodPanel.setOrderPanel(orderPanel);
        foodPanel.setTablesPanel(tablesPanel);
        orderPanel.setTablesPanel(tablesPanel);
        mainPanel.add(foodPanel, "food");
        mainPanel.setBounds(250, 0, 1300, 1000);
        mainPanel.add(homePanel, "home");
        mainPanel.add(staffPanel, "staff");
        mainPanel.add(tablesPanel, "tables");
        mainPanel.add(orderPanel,"Orders");

        f.add(mainPanel);

        JPanel sideBar = new JPanel();
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(40, 60, 80));
        sideBar.setBounds(0, 0, 250, 1000);

        Font font2 = new Font("Arial", Font.BOLD, 25);

        ImageIcon imagemenu = new ImageIcon(getClass().getResource("/Images/Menu.png"));
        Image imgmenu = imagemenu.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnMenu = new JButton("  Menu", new ImageIcon(imgmenu));
        btnMenu.setBounds(10, 10, 230, 40);
        btnMenu.setFont(font2);
        btnMenu.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnMenu);

        JSeparator line = new JSeparator();
        line.setBounds(0, 60, 250, 7);
        sideBar.add(line);

        ImageIcon imagefood = new ImageIcon(getClass().getResource("/Images/Food.png"));
        Image imgfood = imagefood.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnMenuManagement = new JButton("  Food", new ImageIcon(imgfood));
        btnMenuManagement.setBounds(10, 90, 230, 60);
        btnMenuManagement.setFont(font2);
        btnMenuManagement.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnMenuManagement);

        ImageIcon imageorder = new ImageIcon(getClass().getResource("/Images/Orders.png"));
        Image imgorder = imageorder.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnOrders = new JButton("  Orders", new ImageIcon(imgorder));
        btnOrders.setBounds(10, 200, 230, 60);
        btnOrders.setFont(font2);
        btnOrders.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnOrders);

        ImageIcon imagetable = new ImageIcon(getClass().getResource("/Images/Table.png"));
        Image imgtable = imagetable.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnTables = new JButton("  Tables", new ImageIcon(imgtable));
        btnTables.setBounds(10, 300, 230, 60);
        btnTables.setFont(font2);
        btnTables.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnTables);

        ImageIcon imagestaff = new ImageIcon(getClass().getResource("/Images/Staff.png"));
        Image imgst = imagestaff.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnStaff = new JButton("  Staff", new ImageIcon(imgst));
        btnStaff.setBounds(10, 400, 230, 60);
        btnStaff.setFont(font2);
        btnStaff.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnStaff);

        ImageIcon imagelogout = new ImageIcon(getClass().getResource("/Images/Logout.png"));
        Image imglogout = imagelogout.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JButton btnLogout = new JButton(" Logout", new ImageIcon(imglogout));
        btnLogout.setBounds(10, 760, 230, 60);
        btnLogout.setFont(font2);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
        sideBar.add(btnLogout);

        f.add(sideBar);


        btnStaff.addActionListener(e -> cardLayout.show(mainPanel, "staff"));

        btnTables.addActionListener(e -> cardLayout.show(mainPanel, "tables"));

        btnOrders.addActionListener(e -> cardLayout.show(mainPanel,"Orders"));

        btnMenuManagement.addActionListener(e ->
                cardLayout.show(mainPanel, "food")
        );
        btnLogout.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    f,
                    "Are You Sure to Log Out?",
                    "Confirm",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (result == JOptionPane.OK_OPTION) {
                f.setVisible(false);
                new LoginFrame();
            }
        });

        timer = new Timer(5, e -> {
            if (isclose) {
                isOpened -= 10;
                if (isOpened <= 90) {
                    isOpened = 90;
                    isclose = false;
                    timer.stop();
                }
            } else {
                isOpened += 10;
                if (isOpened >= 250) {
                    isOpened = 250;
                    isclose = true;
                    timer.stop();
                }
            }
            sideBar.setSize(isOpened, 1000);
        });

        btnMenu.addActionListener(e -> {
            if (!timer.isRunning()) timer.start();
        });

        f.setResizable(false);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new HomeFrame();
    }
}