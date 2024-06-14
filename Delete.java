import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Delete extends JFrame {
    private JTable eventTable;
    private List<Event> eventList;
    private DefaultTableModel model;

    public Delete(List<Event> eventList, DefaultTableModel model) {
        this.eventList = eventList;
        this.model = model;
        setTitle("Delete or Update Event");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        eventTable = new JTable(model);
        eventTable.setFont(new Font("Arial", Font.PLAIN, 14));
        eventTable.setRowHeight(30);
        eventTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(eventTable);

        JPanel buttonPanel = new JPanel();
        JButton deleteButton = new JButton("Delete");
        JButton updateButton = new JButton("Update");

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEvent();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEvent();
            }
        });

        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void deleteEvent() {
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            eventList.remove(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an event to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateEvent() {
        int selectedRow = eventTable.getSelectedRow();
        if (selectedRow != -1) {
            Event event = eventList.get(selectedRow);
            event.setEmail(JOptionPane.showInputDialog("Update Email", event.getEmail()));
            event.setName(JOptionPane.showInputDialog("Update Name", event.getName()));
            event.setEventName(JOptionPane.showInputDialog("Update Event Name", event.getEventName()));
            event.setDescription(JOptionPane.showInputDialog("Update Description", event.getDescription()));
            event.setDate(JOptionPane.showInputDialog("Update Event Date", event.getDate()));
            event.setVenue(JOptionPane.showInputDialog("Update Event Venue", event.getVenue()));
            event.setEstimatedAttendance(Integer.parseInt(JOptionPane.showInputDialog("Update Estimated Attendance", event.getEstimatedAttendance())));

            // Update the table model
            model.setValueAt(event.getEmail(), selectedRow, 0);
            model.setValueAt(event.getName(), selectedRow, 1);
            model.setValueAt(event.getEventName(), selectedRow, 2);
            model.setValueAt(event.getDescription(), selectedRow, 3);
            model.setValueAt(event.getDate(), selectedRow, 4);
            model.setValueAt(event.getVenue(), selectedRow, 5);
            model.setValueAt(event.getEstimatedAttendance(), selectedRow, 6);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an event to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
