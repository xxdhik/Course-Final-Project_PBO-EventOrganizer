import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class displayEventFrame extends JFrame {
    private JTable eventTable;

    public displayEventFrame(List<Event> eventList) {
        setTitle("Event Details");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Membuat tabel untuk menampilkan event
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Email");
        model.addColumn("Nama");
        model.addColumn("Nama Event");
        model.addColumn("Deskripsi");
        model.addColumn("Tanggal Event");
        model.addColumn("Tempat Event");
        model.addColumn("Perkiraan Kehadiran");

        // Mengisi data dari eventList ke dalam tabel
        for (Event event : eventList) {
            model.addRow(new Object[]{
                    event.getEmail(),
                    event.getName(),
                    event.getEventName(),
                    event.getDescription(),
                    event.getDate(),
                    event.getVenue(),
                    event.getEstimatedAttendance()
            });
        }

        eventTable = new JTable(model);
        eventTable.setFont(new Font("Google Sans", Font.PLAIN, 14));
        eventTable.setRowHeight(30);
        eventTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(eventTable);

        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
