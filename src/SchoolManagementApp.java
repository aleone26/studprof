import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchoolManagementApp {
    public static void main(String[] args) {
        // Creazione del frame principale
        JFrame frame = new JFrame("Gestione Scuola");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Creazione del JTabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Pannello Studenti
        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new BorderLayout());

        // Tabella Studenti
        String[] studentColumns = {"Nome", "Cognome", "Media"};
        DefaultTableModel studentModel = new DefaultTableModel(studentColumns, 0);
        JTable studentTable = new JTable(studentModel);

        // Form inserimento dati Studenti
        JPanel studentForm = new JPanel(new GridLayout(3, 2));
        JTextField studentNameField = new JTextField();
        JTextField studentSurnameField = new JTextField();
        JTextField studentAverageField = new JTextField();

        studentForm.add(new JLabel("Nome:"));
        studentForm.add(studentNameField);
        studentForm.add(new JLabel("Cognome:"));
        studentForm.add(studentSurnameField);
        studentForm.add(new JLabel("Media:"));
        studentForm.add(studentAverageField);

        studentPanel.add(studentForm, BorderLayout.NORTH);
        studentPanel.add(new JScrollPane(studentTable), BorderLayout.CENTER);

        // Pannello Professori
        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new BorderLayout());

        // Tabella Professori
        String[] teacherColumns = {"Nome", "Cognome", "Materia"};
        DefaultTableModel teacherModel = new DefaultTableModel(teacherColumns, 0);
        JTable teacherTable = new JTable(teacherModel);

        // Form inserimento dati Professori
        JPanel teacherForm = new JPanel(new GridLayout(3, 2));
        JTextField teacherNameField = new JTextField();
        JTextField teacherSurnameField = new JTextField();
        JTextField teacherSubjectField = new JTextField();

        teacherForm.add(new JLabel("Nome:"));
        teacherForm.add(teacherNameField);
        teacherForm.add(new JLabel("Cognome:"));
        teacherForm.add(teacherSurnameField);
        teacherForm.add(new JLabel("Materia:"));
        teacherForm.add(teacherSubjectField);

        teacherPanel.add(teacherForm, BorderLayout.NORTH);
        teacherPanel.add(new JScrollPane(teacherTable), BorderLayout.CENTER);

        // Aggiunta dei pannelli al JTabbedPane
        tabbedPane.addTab("Studenti", studentPanel);
        tabbedPane.addTab("Professori", teacherPanel);

        // Creazione del pannello inferiore con il bottone "Aggiungi"
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Aggiungi");
        buttonPanel.add(addButton);

        // Aggiunta del JTabbedPane e del bottone al frame principale
        frame.setLayout(new BorderLayout());
        frame.add(tabbedPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Azione bottone "Aggiungi"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTab = tabbedPane.getSelectedIndex();
                if (selectedTab == 0) { // Tab Studenti
                    String name = studentNameField.getText();
                    String surname = studentSurnameField.getText();
                    String average = studentAverageField.getText();
                    if (!name.isEmpty() && !surname.isEmpty() && !average.isEmpty()) {
                        studentModel.addRow(new Object[]{name, surname, average});
                        studentNameField.setText("");
                        studentSurnameField.setText("");
                        studentAverageField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Per favore, compila tutti i campi!");
                    }
                } else if (selectedTab == 1) { // Tab Professori
                    String name = teacherNameField.getText();
                    String surname = teacherSurnameField.getText();
                    String subject = teacherSubjectField.getText();
                    if (!name.isEmpty() && !surname.isEmpty() && !subject.isEmpty()) {
                        teacherModel.addRow(new Object[]{name, surname, subject});
                        teacherNameField.setText("");
                        teacherSurnameField.setText("");
                        teacherSubjectField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Per favore, compila tutti i campi!");
                    }
                }
            }
        });

        // Visualizza il frame
        frame.setVisible(true);
    }
}
