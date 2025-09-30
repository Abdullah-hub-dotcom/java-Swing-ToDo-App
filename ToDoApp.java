import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> tasklist;
    private JTextField taskfield;
    private JButton addButton,DeleteButton;
    public ToDoApp(){
        setTitle("To-Do List App");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        taskfield=new JTextField(20);
        addButton=new JButton("Add Task");
        DeleteButton=new JButton("Delete Task");
        taskListModel = new DefaultListModel<>();
        tasklist = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(tasklist);
        JPanel inputPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        inputPanel.add(taskfield);
        inputPanel.add(addButton);
        inputPanel.add(DeleteButton);
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskfield.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskfield.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Enter a task!");
                }
            }
        });
        DeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = tasklist.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a task to delete!");
                }
            }
        });


    }
    public static void main() {
        SwingUtilities.invokeLater(() -> new ToDoApp().setVisible(true));
    }
}