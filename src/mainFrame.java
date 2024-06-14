import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class mainFrame extends JFrame {
    private JButton addEventButton;
    private JButton displayEventButton;
    private List<Event> eventList; // Daftar event

    public mainFrame() {
        setTitle("FINAL PROJECT PBO");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        eventList = new ArrayList<>(); // Inisialisasi daftar event

        // Panel utama dengan GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(96, 150, 180));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Label header
        JLabel headerLabel = new JLabel("Event Organizer");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Google Sans", Font.BOLD, 48));
        headerLabel.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(headerLabel, gbc);

        // Sub-panel untuk tombol
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(new Color(96, 150, 180));

        // Tombol "Add Event"
        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Google Sans", Font.PLAIN, 24));
        addEventButton.setPreferredSize(new Dimension(200, 50));
        addEventButton.setBackground(new Color(238, 233, 218));
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAddEventForm();
            }
        });
        buttonPanel.add(addEventButton);

        // Tombol "Display Event"
        displayEventButton = new JButton("Display Event");
        displayEventButton.setFont(new Font("Google Sans", Font.PLAIN, 24));
        displayEventButton.setPreferredSize(new Dimension(200, 50));
        displayEventButton.setBackground(new Color(238, 233, 218));
        displayEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayEventDetails();
            }
        });
        buttonPanel.add(displayEventButton);

        // Menambahkan panel tombol ke panel utama
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(buttonPanel, gbc);

        // Menambahkan panel utama ke frame
        add(mainPanel);

        setVisible(true);
    }

    // Method untuk membuka jendela formulir tambah event
    private void openAddEventForm() {
        new addEventFrame(eventList);
    }

    // Method untuk menampilkan detail event
    private void displayEventDetails() {
        new displayEventFrame(eventList);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new mainFrame());
    }
}
