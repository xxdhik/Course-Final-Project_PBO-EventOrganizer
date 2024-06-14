import javax.swing.*;
import java.awt.*;
import java.util.List;

public class addEventFrame extends JFrame {
    private JTextField emailField;
    private JTextField nameField;
    private JTextField eventNameField;
    private JTextField eventDateField;
    private JTextField eventVenueField;
    private JTextField descriptionEventField;
    private JTextField estimatedAttendanceField;
    private JButton submitButton;
    private List<Event> eventList;

    public addEventFrame(List<Event> eventList) {
        this.eventList = eventList;

        setTitle("Add Event");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Formulir tambah event
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Google Sans", Font.PLAIN, 14);
        Font fieldFont = new Font("Google Sans", Font.PLAIN, 14);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        formPanel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        // Nama
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setFont(labelFont);
        formPanel.add(nameLabel, gbc);

        nameField = new JTextField(20);
        nameField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        // Nama Event
        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel nameEventLabel = new JLabel("Nama Event:");
        nameEventLabel.setFont(labelFont);
        formPanel.add(nameEventLabel, gbc);

        eventNameField = new JTextField(20);
        eventNameField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(eventNameField, gbc);

        // Deskripsi Event
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel descriptionLabel = new JLabel("Deskripsi Event:");
        descriptionLabel.setFont(labelFont);
        formPanel.add(descriptionLabel, gbc);

        descriptionEventField = new JTextField(20);
        descriptionEventField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(descriptionEventField, gbc);

        // Tanggal Event
        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel dateLabel = new JLabel("Tanggal Event:");
        dateLabel.setFont(labelFont);
        formPanel.add(dateLabel, gbc);

        eventDateField = new JTextField(20);
        eventDateField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(eventDateField, gbc);

        // Tempat Event
        gbc.gridx = 0;
        gbc.gridy = 5;
        JLabel venueLabel = new JLabel("Tempat Event:");
        venueLabel.setFont(labelFont);
        formPanel.add(venueLabel, gbc);

        eventVenueField = new JTextField(20);
        eventVenueField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(eventVenueField, gbc);

        // Perkiraan Kehadiran
        gbc.gridx = 0;
        gbc.gridy = 6;
        JLabel attendanceLabel = new JLabel("Perkiraan Kehadiran:");
        attendanceLabel.setFont(labelFont);
        formPanel.add(attendanceLabel, gbc);

        estimatedAttendanceField = new JTextField(20);
        estimatedAttendanceField.setFont(fieldFont);
        gbc.gridx = 1;
        formPanel.add(estimatedAttendanceField, gbc);

        // Tombol Submit
        submitButton = new JButton("Tambahkan Event");
        submitButton.setFont(new Font("Google Sans", Font.BOLD, 14));
        submitButton.setBackground(new Color(96, 150, 180));
        submitButton.setForeground(Color.WHITE);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        submitButton.addActionListener(e -> addEvent());
        formPanel.add(submitButton, gbc);

        add(formPanel);
        setVisible(true);
    }

    private void addEvent() {
        try {
            String email = emailField.getText().trim();
            String name = nameField.getText().trim();
            String eventName = eventNameField.getText().trim();
            String description = descriptionEventField.getText().trim();
            String date = eventDateField.getText().trim();
            String venue = eventVenueField.getText().trim();
            int estimatedAttendance = Integer.parseInt(estimatedAttendanceField.getText().trim());

            if (email.isEmpty() || name.isEmpty() || eventName.isEmpty() || description.isEmpty() ||
                    date.isEmpty() || venue.isEmpty() || estimatedAttendanceField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Event event = new Event(eventName, description, date, venue, email, name, estimatedAttendance);
            eventList.add(event);

            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format in estimated attendance", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
