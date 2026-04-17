import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame
{
    int sidebarWidth=250,isOpened=250;
    Timer timer;
    boolean isclose=true;
    public  HomeFrame() {

        JFrame f = new JFrame("Home Frame");
        Font font = new Font("Arial", Font.BOLD, 25);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

        JPanel sideBar=new JPanel();
        sideBar.setLayout(null);
        sideBar.setBackground(new Color(40,60,80));
        sideBar.setBounds(0,0,250,1000);

        ImageIcon imagemenu = new ImageIcon(
                getClass().getResource("/Images/Menu.png"));
        Image imgmenu = imagemenu.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon smallIconmenu = new ImageIcon(imgmenu);
        JButton btnMenu=new JButton(" Menu",smallIconmenu);
        btnMenu.setBounds(10,10,230,40);
        btnMenu.setFocusPainted(false);
        btnMenu.setFont(font);
        btnMenu.setHorizontalAlignment(SwingConstants.LEFT);
        btnMenu.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnMenu.setVerticalTextPosition(SwingConstants.CENTER);
        btnMenu.setIconTextGap(10);
        sideBar.add(btnMenu);

        JSeparator line=new JSeparator();
        line.setBounds(0,60,250,7);
        sideBar.add(line);

        ImageIcon imagefood=new ImageIcon(
                getClass().getResource("/Images/Food.png"));
        Image imgfood=imagefood.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon foodsmall=new ImageIcon(imgfood);
        JButton btnMenuManagement=new JButton(" Food",foodsmall);
        btnMenuManagement.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnMenuManagement.setVerticalTextPosition(SwingConstants.CENTER);
        btnMenuManagement.setHorizontalAlignment(SwingConstants.LEFT);
        btnMenuManagement.setIconTextGap(10);
        btnMenuManagement.setBounds(10,90,230,60);
        btnMenuManagement.setFont(font);
        sideBar.add(btnMenuManagement);

        ImageIcon imageDashboard = new ImageIcon(
                getClass().getResource("/Images/Dashboard.png"));
        Image img = imageDashboard.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon smallIcon = new ImageIcon(img);
        JButton btnDashBoard = new JButton(" Dashboard", smallIcon);
        btnDashBoard.setBounds(10,190,230,60);
        btnDashBoard.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnDashBoard.setVerticalTextPosition(SwingConstants.CENTER);
        btnDashBoard.setFont(font);
        btnDashBoard.setHorizontalAlignment(SwingConstants.LEFT);
        btnDashBoard.setIconTextGap(10);
        sideBar.add(btnDashBoard);

        ImageIcon imageorder=new ImageIcon(
                getClass().getResource("/Images/Orders.png"));
        Image imgorder=imageorder.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon ordersmall=new ImageIcon(imgorder);
        JButton btnOrders=new JButton(" Orders",ordersmall);
        btnOrders.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnOrders.setVerticalTextPosition(SwingConstants.CENTER);
        btnOrders.setHorizontalAlignment(SwingConstants.LEFT);
        btnOrders.setIconTextGap(10);
        btnOrders.setBounds(10,290,230,60);
        btnOrders.setFont(font);
        sideBar.add(btnOrders);

        ImageIcon imagetables=new ImageIcon(
                getClass().getResource("/Images/Table.png"));
        Image imgtable=imagetables.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH);
        ImageIcon tablesmall=new ImageIcon(imgtable);
        JButton btntables=new JButton(" Tables",tablesmall);
        btnDashBoard.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnDashBoard.setVerticalTextPosition(SwingConstants.CENTER);
        btntables.setHorizontalAlignment(SwingConstants.LEFT);
        btntables.setIconTextGap(10);
        btntables.setBounds(10,390,230,60);
        btntables.setFont(font);
        sideBar.add(btntables);


        ImageIcon imagestaff = new ImageIcon(
                getClass().getResource("/Images/Staff.png"));
        Image imgst = imagestaff.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon smallIconstaff = new ImageIcon(imgst);
        JButton btnStaff = new JButton(" Staff", smallIconstaff);
        btnDashBoard.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnDashBoard.setVerticalTextPosition(SwingConstants.CENTER);
        btnStaff.setHorizontalAlignment(SwingConstants.LEFT);
        btnStaff.setIconTextGap(10);
        btnStaff.setBounds(10,490,230,60);
        btnStaff.setFont(font);
        sideBar.add(btnStaff);


        ImageIcon imagelogout = new ImageIcon(
                getClass().getResource("/Images/Logout.png"));
        Image imglogout = imagelogout.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon smallIconlogout = new ImageIcon(imglogout);
        JButton btnLogout = new JButton(" Logout", smallIconlogout);
        btnDashBoard.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnDashBoard.setVerticalTextPosition(SwingConstants.CENTER);
        btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
        btnLogout.setIconTextGap(10);
        btnLogout.setBounds(10, 760, 230, 60);
        btnLogout.setFont(font);
        sideBar.add(btnLogout);

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result =JOptionPane.showConfirmDialog(f, "Are You Sure to Log Out?",
                 "Confirm", JOptionPane.OK_CANCEL_OPTION
                );

                if (result == JOptionPane.OK_OPTION) {
                    f.setVisible(false);
                    new LoginFrame();
                }
            }
        });
        timer= new Timer(5, e -> {
            if(isclose){
                isOpened-=10;
                if(isOpened<=90){
                    isOpened=90;
                    isclose=false;
                    timer.stop();
                }
            }else {
                isOpened += 10;
                if (isOpened >= 250) {
                    isOpened = 250;
                    isclose = true;
                    timer.stop();
                }
            }
            sideBar.setSize(isOpened,1000);
        });

        btnMenu.addActionListener(e -> {

            if(!timer.isRunning()){
                timer.start();
            }
        });

        f.add(sideBar);
        f.setResizable(false);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static void main(String[] args){
        new HomeFrame();
    }
}
