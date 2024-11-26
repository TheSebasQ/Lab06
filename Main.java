package Hilos;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;

public class Main {
public static void main(String[] args) throws UnsupportedLookAndFeelException {
    FlatCarbonIJTheme.setup();
    UIManager.put("Button.arc", 999);
    metods metodos= new metods();

    SwingUtilities.updateComponentTreeUI(metodos);
    metodos.setVisible(true);
    }
}