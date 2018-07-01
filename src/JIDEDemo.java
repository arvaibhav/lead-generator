import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.jidesoft.swing.AutoCompletionComboBox;

public class JIDEDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AutoCompletionComboBox comboBox;
                Object[] elements = new Object[]{"Ester", "Jordi", "Jordina",
                    "Jorge", "Sergi"};
                comboBox = new AutoCompletionComboBox(elements);
                comboBox.setStrict(false);

                JOptionPane.showMessageDialog(null, comboBox);
            }
        });
    }
}