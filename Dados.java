package Hilos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dados extends JFrame {
    private JPanel panelDados = new JPanel();
    private JButton atras = new JButton("⬅️");
    private JButton iniciar = new JButton("🎲");
    
    private ImageIcon carasDados[] = new ImageIcon[6];
    private JLabel imagenes1 = new JLabel();
    private JLabel imagenes2 = new JLabel();

    public Dados() {
        setTitle("Asignación de Turnos - EPS");
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Configuración de la ventana
        setBounds(0, 0, 500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        panelDados.setLayout(null);
        panelDados.setBackground(Color.darkGray);
        getContentPane().add(panelDados);

        // Botón Atras
        atras.setBounds(0, 0, 60, 60);
        panelDados.add(atras);
        atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Regresar a la pantalla anterior
                metods metodos = new metods();
                metodos.setVisible(true);
                dispose();  
            }
        });

        // Botón Iniciar
        iniciar.setBounds(100, 0, 60, 60);
        panelDados.add(iniciar);
        iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lanzar los dados
                new Thread(new LanzarDado1()).start();
                new Thread(new LanzarDado2()).start();
            }
        });

        // Inicializar las imágenes de los dados
        inicializarImagenes();

        // Configuración de las imágenes de los dados
        imagenes1.setIcon(carasDados[0]);
        imagenes1.setBounds(50, 90, carasDados[0].getIconWidth(), carasDados[0].getIconHeight());
        panelDados.add(imagenes1);

        imagenes2.setIcon(carasDados[0]);
        imagenes2.setBounds(250, 90, carasDados[0].getIconWidth(), carasDados[0].getIconHeight());
        panelDados.add(imagenes2);

        // Mostrar la ventana
        setVisible(true);
    }

    private void inicializarImagenes() {
        carasDados[0] = new ImageIcon(getClass().getResource("/Hilos/images/1.png"));
        carasDados[1] = new ImageIcon(getClass().getResource("/Hilos/images/2.png"));
        carasDados[2] = new ImageIcon(getClass().getResource("/Hilos/images/3.png"));
        carasDados[3] = new ImageIcon(getClass().getResource("/Hilos/images/4.png"));
        carasDados[4] = new ImageIcon(getClass().getResource("/Hilos/images/5.png"));
        carasDados[5] = new ImageIcon(getClass().getResource("/Hilos/images/6.png"));
    }

    // Clase que lanza el primer dado
    private class LanzarDado1 implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int randomIndex = (int) (Math.random() * carasDados.length);
                    imagenes1.setIcon(carasDados[randomIndex]);
                    panelDados.repaint();
                    Thread.sleep(200); // Simula el lanzamiento del dado
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Clase que lanza el segundo dado
    private class LanzarDado2 implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    int randomIndex = (int) (Math.random() * carasDados.length);
                    imagenes2.setIcon(carasDados[randomIndex]);
                    panelDados.repaint();
                    Thread.sleep(200); // Simula el lanzamiento del dado
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    // Clase para regresar a la pantalla anterior (asumida como "metods")
    private class metods extends JFrame {
        public metods() {
            setTitle("Pantalla Anterior");
            setBounds(0, 0, 500, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dados();
    }
}


