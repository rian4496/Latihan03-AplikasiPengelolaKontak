
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author HADI PC
 */
public class Utilities {

    final private Component parent;
    final private boolean silent;

    public Utilities(Component parent, boolean silent) {
        this.parent = parent;
        this.silent = silent;
    }

    public Utilities(Component parent) {
        this.silent = false;
        this.parent = parent;
    }

    public static void clearSaatFocus(FocusEvent evt) {
        var source = evt.getSource();
        if (source instanceof JTextField) {
            ((JTextField) source).setText("");
        }
    }

    public static void clearInput(Object[] inputan) {
        for (var input : inputan) {
            if (input instanceof JTextField) {
                ((JTextField) input).setText("");
            } else if (input instanceof JComboBox) {
                ((JComboBox) input).setSelectedIndex(-1);
            }
        }
    }

    public boolean validasiTidakKosong(JTextField textField, String nama) {
        if (textField.getText().isEmpty()) {
            this.showErrorDialog("Inputan nilai " + nama + " tidak boleh kosong!");
            return true;
        }

        return false;
    }

    public boolean validasiTidakNull(JComboBox combobox, String nama) {
        var idx = combobox.getSelectedIndex();
        if (idx == -1 || idx > (combobox.getModel().getSize() - 1)) {
            this.showErrorDialog("Inputan pilihan " + nama + " belum dipilih!");
            return true;
        }

        return false;
    }

    public boolean validasiInputHanyaAngka(KeyEvent event) {
        char c = event.getKeyChar();
        if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
            this.showErrorDialog("Msukkan input angka!");
            event.consume();
            return true;
        }

        return false;
    }

    public void showErrorDialog(String pesan) {
        if (!this.silent) {
            JOptionPane.showMessageDialog(parent, pesan, "error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
