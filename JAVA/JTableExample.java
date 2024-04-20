import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class JTableExample extends JFrame {

    public JTableExample() 
    {
        setTitle("JTable Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        Object[][] data = {
                {1, "KAANMS", "SATANA",2021},
                {2,"SPH", "NAMPUR", 2034},
                {3,"RKM", "KALVAN", 2022},
                {4,"KTHM", "NASHIK", 2011},          
        };

        String[] columnNames = {"CID", "CNAME", "ADDRESS","YEAR"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) 
    {
        new JTableExample();
    }
}
