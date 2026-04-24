import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class TableManager {
    public static ArrayList<Table> tables = new ArrayList<>();
}
public class TablesPanel extends JPanel
{
    ArrayList<Table>tables=TableManager.tables;
    ArrayList<JButton> buttons=new ArrayList<>();
    public TablesPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        Font font = new Font("Arial", Font.BOLD, 40);
        JLabel lbltitle = new JLabel("Table Management");
        lbltitle.setBounds(450, 30, 400, 40);
        lbltitle.setFont(font);
        lbltitle.setForeground(Color.RED);
        add(lbltitle);

        if (tables.isEmpty()) {
            for (int i = 1; i <= 12; i++) {
                if (i == 1 || i == 4 || i == 7) {
                    tables.add(new Table(i, 2));
                } else {
                    tables.add(new Table(i, 4));
                }
            }
        }
        int x = 150, y = 150;
        for (int i = 0; i < tables.size(); i++) {
            Table t = tables.get(i);
            JButton btn = new JButton();
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setBounds(x, y, 250, 60);
            updateButton(btn, t);
            int index = i;
            btn.addActionListener(e -> {
                toggelStatus(tables.get(index));
                updateButton(btn, tables.get(index));
            });
            buttons.add(btn);
            add(btn);
            x += 350;
            if (x > 850) {
                x = 150;
                y += 150;
            }
        }
    }
    private  void toggelStatus(Table t){
        switch (t.getStatus()){
            case "Empty":
                t.setStatus("Busy");
                break;
            case "Busy":
                t.setStatus("Reserved");
                break;
            case "Reserved":
                t.setStatus("Empty");
                break;
        }
    }
    private  void updateButton(JButton btn,Table t){
        btn.setText("Table ["+t.getNum()+"] is : "+t.getStatus());
        switch (t.getStatus()){
            case "Empty":
                btn.setBackground(Color.GREEN);
                break;
            case "Busy":
                btn.setBackground(Color.RED);
                break;
            case "Reserved":
                btn.setBackground(Color.ORANGE);
                break;
        }
        btn.setOpaque(true);
        btn.setBorderPainted(false);
    }
    public void updateTableStatus(int tableNum, String status) {
        for (int i = 0; i < tables.size(); i++) {
            Table t = tables.get(i);

            if (t.getNum() == tableNum) {
                t.setStatus(status);

                JButton btn = buttons.get(i);
                updateButton(btn, t);
                break;
            }
        }
    }
}
