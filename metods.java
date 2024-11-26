package Hilos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;


public class metods extends JFrame  {
    private JButton Boton_D = new JButton("DADOS");
    private JButton Boton_R= new JButton("RULETA");
    private JButton Salir= new JButton("  ✖️");

    private Fondo_Panel Fondo= new Fondo_Panel();
    public metods(){
        this.setBounds(0, 0, 640, 366);
        this.setVisible(true);
        this.setContentPane(Fondo);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializar_Metodos();
    }
    private void inicializar_Metodos(){
        Botones();
    }
    private void Botones(){
        Boton_D.setBounds(0,0,100,100);
        Boton_R.setBounds(0,150,100,100);
        Salir.setBounds(320, 183, 100, 100);
        Fondo.add(Boton_D);
        Fondo.add(Boton_R);
        Fondo.add(Salir);
        Boton_D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                Dados dados = new Dados();
                dados.setVisible(true); 
                dispose();  
                             
            }
        });
        Boton_R.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
                Ruleta ruleta = new Ruleta();
                ruleta.setVisible(true); 
                dispose();              
            }
        });
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
 
    public class Fondo_Panel extends JPanel {
        private Image Fondo_Pantalla;

        public Fondo_Panel() {
            Fondo_Pantalla = new ImageIcon(getClass().getResource("/Hilos/images/universe-8622213_640.jpg")).getImage();
            this.setLayout(null);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.drawImage(Fondo_Pantalla, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
        }
    }
}

