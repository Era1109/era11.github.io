package Classes;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MusicTableFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JButton deleteButton, updateButton;
    private Musics musics;

    public MusicTableFrame(Musics musics) {
        this.musics = musics;
        this.model = new DefaultTableModel();
        this.model.addColumn("Music Name");
        this.model.addColumn("Artist");
        this.model.addColumn("Duration");
        this.model.addColumn("Music Path");
        this.model.addColumn("Thumbnail Path");

        initializeForm();
        createTable();
        populateTable();

        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initializeForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
              
                    String musicName = model.getValueAt(selectedRow, 0).toString();
                    musics.deleteMusic(musicName);
                    model.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(MusicTableFrame.this, "Music deleted successfully.");
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                 
                    String musicName = model.getValueAt(selectedRow, 0).toString();
                    JOptionPane.showMessageDialog(MusicTableFrame.this, "Music updated successfully.");
                }
            }
        });

        this.add(panel);
    }

    private void createTable() {
        table.setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.setBackground(new Color(174, 247, 255));
        table.setRowHeight(25);
        table.setSelectionBackground(new Color(255, 153, 51));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
    }

    private void populateTable() {
    Music[] allMusic = musics.getAllMusic();
    if (allMusic != null) {
        for (Music music : allMusic) {
            if (music != null) {
                Object[] rowData = {
                        music.getName(),
                        music.getArtist(),
                        music.getDuration(),
                        music.getMusicpath(),
                        music.getThumpath()
                };
                model.addRow(rowData);
            }
        }
    }
}
}
