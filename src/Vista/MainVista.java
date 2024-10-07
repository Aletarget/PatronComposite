package Vista;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import ProductosConcretos.ProductoSimple;
import ProductosConcretos.ProductosCompuestos;
import ProductosConcretos.Salida;

public class MainVista extends JFrame {
    private JPanel productos;
    private JPanel memoria;
    private JPanel disco;
    private JPanel procesador;
    private JButton btnOrden;
    private JLabel titulo;


    private ProductoSimple memoriaString = null;
    private ProductoSimple procesadorString = null;
    private ProductoSimple discoString = null;

    private int ordenNro = 1;
    public MainVista(){
        setLayout(new BorderLayout());
        setTitle("Sistema de armados de computadores");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        titulo = new JLabel("Bienvenido, seleccione por favor los componentes para su computador", JLabel.CENTER);
        add(titulo, BorderLayout.NORTH);

        productos = new JPanel();
        productos.setLayout(new BoxLayout(productos, BoxLayout.Y_AXIS));
        JLabel nom = new JLabel("Digite su nombre o empresa:");
        nom.setAlignmentX(Component.CENTER_ALIGNMENT);
        JTextArea nombre = new JTextArea();
        nombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        nombre.setPreferredSize(new Dimension(100, 20));

        JPanel nombres = new JPanel();
        nombres.setLayout(new BoxLayout(nombres, BoxLayout.X_AXIS));
        nombres.setMaximumSize(new Dimension(400,20));
        nombres.add(nom);
        nombres.add(nombre);

        productos.add(nombres);

        memoria = new JPanel();
        ImageIcon ram = new ImageIcon(getClass().getResource("./Images/ram.png"));
        JPanel subMemoria1 = new JPanel();
        subMemoria1.setLayout(new BoxLayout(subMemoria1, BoxLayout.Y_AXIS));
        subMemoria1.setSize(new Dimension(90, 80));
        JPanel subMemoria2 = new JPanel();
        subMemoria2.setLayout(new BoxLayout(subMemoria2, BoxLayout.Y_AXIS));
        subMemoria2.setSize(new Dimension(90, 80));
        
        JButton mem1 = new JButton(ram);
        JLabel mem1Text = new JLabel("8 GB");
        mem1.setAlignmentX(Component.CENTER_ALIGNMENT);
        mem1Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton mem2 = new JButton(ram);
        JLabel mem2Text = new JLabel("4 GB");
        mem2.setAlignmentX(Component.CENTER_ALIGNMENT);
        mem2Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        subMemoria1.add(mem1Text);
        subMemoria1.add(mem1);

        subMemoria2.add(mem2Text);
        subMemoria2.add(mem2);

        memoria.setLayout(new BoxLayout(memoria, BoxLayout.X_AXIS));

        memoria.add(subMemoria1);
        memoria.add(subMemoria2);
        JLabel memorias = new JLabel("Seleccione la cantidad de memoria:");
        memorias.setAlignmentX(Component.CENTER_ALIGNMENT);
        productos.add(memorias);
        productos.add(memoria);
        

        disco = new JPanel();
        ImageIcon ssd = new ImageIcon(getClass().getResource("./Images/discoSolido.png"));
        ImageIcon hdd = new ImageIcon(getClass().getResource("./Images/discoDuro.png"));

        JPanel subdisco1 = new JPanel();
        subdisco1.setLayout(new BoxLayout(subdisco1, BoxLayout.Y_AXIS));
        subdisco1.setSize(new Dimension(90, 80));
        JPanel subdisco2 = new JPanel();
        subdisco2.setLayout(new BoxLayout(subdisco2, BoxLayout.Y_AXIS));
        subdisco2.setSize(new Dimension(90, 80));

        JButton disco1 = new JButton(ssd);
        JLabel disco1Text = new JLabel("Disco Solido");
        disco1.setAlignmentX(Component.CENTER_ALIGNMENT);
        disco1Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton disco2 = new JButton(hdd);
        JLabel disco2Text = new JLabel("Disco Duro");
        disco2.setAlignmentX(Component.CENTER_ALIGNMENT);
        disco2Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        subdisco1.add(disco1Text);
        subdisco1.add(disco1);

        subdisco2.add(disco2Text);
        subdisco2.add(disco2);

        disco = new JPanel();
        disco.setLayout(new BoxLayout(disco, BoxLayout.X_AXIS));

        disco.add(subdisco1);
        disco.add(subdisco2);

        productos.add(disco);



        procesador = new JPanel();
        procesador.setLayout(new BoxLayout(procesador, BoxLayout.X_AXIS));

        ImageIcon intel = new ImageIcon(getClass().getResource("./Images/intel.png"));
        ImageIcon amd = new ImageIcon(getClass().getResource("./Images/amd.png"));

        JPanel subproc1 = new JPanel();
        subproc1.setLayout(new BoxLayout(subproc1, BoxLayout.Y_AXIS));
        JPanel subproc2 = new JPanel();
        subproc2.setLayout(new BoxLayout(subproc2, BoxLayout.Y_AXIS));

        JButton proc1 = new JButton(amd);
        JLabel proc1Text = new JLabel("AMD");
        proc1.setAlignmentX(Component.CENTER_ALIGNMENT);
        proc1Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton proc2 = new JButton(intel);
        JLabel proc2Text = new JLabel("Intel");
        proc2.setAlignmentX(Component.CENTER_ALIGNMENT);
        proc2Text.setAlignmentX(Component.CENTER_ALIGNMENT);

        subproc1.add(proc1Text);
        subproc1.add(proc1);

        subproc2.add(proc2Text);
        subproc2.add(proc2);

        procesador = new JPanel();
        procesador.setLayout(new BoxLayout(procesador, BoxLayout.X_AXIS));

        procesador.add(subproc1);
        procesador.add(subproc2);

        productos.add(procesador);

        add(productos, BorderLayout.CENTER);
        btnOrden = new JButton("ORDENAR");
        add(btnOrden, BorderLayout.SOUTH);


        mem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoriaString = new ProductoSimple("Memoria 8 GB", 160000, "Crucial");
            }
        });
        mem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memoriaString = new ProductoSimple("Memoria 4 GB", 100000, "Crucial");
            }
        });
        disco1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discoString = new ProductoSimple("Disco Solido 512 GB", 21000, "Samsung");
            }
        });
        
        disco2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discoString = new ProductoSimple("Disco duro 512 GB", 85000, "Western Digital");
            }
        });
        
        proc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesadorString = new ProductoSimple("Procesador AMD", 500000, "AMD");
            }
        });
        
        proc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesadorString = new ProductoSimple("Procesador INTEL", 520000, "Intel");
            }
        });

        btnOrden.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                if (discoString == null || memoriaString == null || procesadorString == null) {
                    JOptionPane.showMessageDialog(null,"No se ha seleccionado al menos uno de los componentes intentelo de nuevo","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    ProductosCompuestos orden = new ProductosCompuestos("VALOR COMPUTADOR");
                    orden.SumProductos(discoString);
                    orden.SumProductos(memoriaString);
                    orden.SumProductos(procesadorString);
                    Salida salida = new Salida(ordenNro, nombre.getText());
                    salida.adicionProductos(memoriaString);
                    salida.adicionProductos(discoString);
                    salida.adicionProductos(procesadorString);
                    String textsalida = salida.imprimir();
                    System.out.println(textsalida);
                    JOptionPane.showMessageDialog(null,salida.imprimir());
                    ordenNro++;
                }
            } 
        });
    }
}
