import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;
    private JButton revertirButton;
    private JButton buscar;
    private JButton ordenarAscendenteButton;
    private JButton ordenarDescendenteButton;
    private Cola cola = new Cola();
    private JButton buscarButton;

    public ColaGUI() {

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                try {
                    int valor = Integer.parseInt(input);
                    cola.buscarElemento(valor, txtResultado);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                try {
                    int valor = Integer.parseInt(input);
                    cola.encolar(valor, txtResultado);
                    txtElemento.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.desencolar(txtResultado);
            }
        });
        revertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.invertirCola(txtResultado);
            }
        });
        ordenarAscendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.ordenarCola(true, txtResultado);
            }
        });
        ordenarDescendenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cola.ordenarCola(false, txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ColaGUI");
        frame.setContentPane(new ColaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
