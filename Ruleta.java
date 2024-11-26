package Hilos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ruleta extends JFrame { 
    private JPanel Panel_Ruleta= new JPanel();
    private JButton Atras= new JButton("⬅️");
    public Ruleta(){
        this.setBounds(0, 0, 800, 600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Metods_Ruleta();
    }
    private void Metods_Ruleta(){
        Panel_Ruleta();        
        Botones();
    }
    private void Panel_Ruleta(){
        this.getContentPane().add(Panel_Ruleta);
        Panel_Ruleta.setLayout(null);

    }
    private void Botones(){
        Atras.setBounds(0, 0, 100, 100);
        Panel_Ruleta.add(Atras);
        
        Atras.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e){
                metods metodos= new metods();
                metodos.setVisible(true);
                dispose();  
            }
        });
    }
}