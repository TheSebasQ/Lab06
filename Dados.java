package Hilos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JComboBox;

public class Dados extends JFrame {
    private JPanel Panel_Dados= new JPanel();
    private JButton Atras= new JButton("  ⬅️");
    private JButton Iniciar= new JButton("🎲 ");
    
    private ImageIcon Caras_Dados[]= new ImageIcon[6];
    private JLabel imagenes1= new JLabel(Caras_Dados[0]);
    private JLabel imagenes2= new JLabel(Caras_Dados[0]);

   // private hilo1 Dado1= new hilo1();
    //private JComboBox <Integer> 

    public Dados(){
        this.setBounds(0, 0, 500, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Metods_Dados();
    }
    private void Metods_Dados(){
        Panel_Dados();        
        Botones();
        Poner_Dados();
        //desplegable();
    }
    private void Panel_Dados(){
        this.getContentPane().add(Panel_Dados);
        Panel_Dados.setLayout(null);
        Panel_Dados.setBackground(Color.darkGray);
    }
    private void Botones(){
        Atras.setBounds(0, 0, 60, 60);
        Panel_Dados.add(Atras);
        Iniciar.setBounds(100, 0, 60, 60);
        Panel_Dados.add(Iniciar);

        Atras.addActionListener(new ActionListener() {
            public void  actionPerformed(ActionEvent e){
                metods metodos= new metods();
                metodos.setVisible(true);
                dispose();  
            }
        });   
        Iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new Thread(new LanzarDado1()).start();
                new Thread(new LanzarDado2()).start();

            }
        });    
    }
    private void Poner_Dados(){
        Caras_Dados[0]= new ImageIcon(getClass().getResource("/Hilos/images/1.png"));
        Caras_Dados[1]=new ImageIcon(getClass().getResource("/Hilos/images/2.png"));
        Caras_Dados[2]=new ImageIcon(getClass().getResource("/Hilos/images/3.png"));
        Caras_Dados[3]=new ImageIcon(getClass().getResource("/Hilos/images/4.png"));
        Caras_Dados[4]=new ImageIcon(getClass().getResource("/Hilos/images/5.png"));
        Caras_Dados[5]=new ImageIcon(getClass().getResource("/Hilos/images/6.png"));

        imagenes1.setIcon(Caras_Dados[0]);
        imagenes1.setBounds(50, 90, Caras_Dados[0].getIconWidth(), Caras_Dados[0].getIconHeight());
        Panel_Dados.add(imagenes1);
        
        imagenes2.setIcon(Caras_Dados[0]);
        imagenes2.setBounds(250, 90, Caras_Dados[0].getIconWidth(), Caras_Dados[0].getIconHeight());
        Panel_Dados.add(imagenes2);
        
    }
    private class LanzarDado1 implements Runnable {
          @Override
          public void run(){
            try {
                for (int i = 0; i < 10; i++) { 
                    int randomIndex = (int) (Math.random() * Caras_Dados.length);
                    imagenes1.setIcon(Caras_Dados[randomIndex]);
                    Panel_Dados.repaint();
                    Thread.sleep(200); 
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
          }
    }
    private class LanzarDado2 implements Runnable {
            @Override
            public void run(){
            try {
                for (int i = 0; i < 10; i++) { 
                  int randomIndex = (int) (Math.random() * Caras_Dados.length);
                  imagenes2.setIcon(Caras_Dados[randomIndex]);
                  Panel_Dados.repaint();
                  Thread.sleep(200);
              }
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
        }
  }
}



