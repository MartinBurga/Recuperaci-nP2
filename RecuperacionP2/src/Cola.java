import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class Cola {
    private Nodo frente;
    private Nodo finalCola;
    private int tamano;

    public Cola() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    public void encolar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            nuevoNodo.anterior = finalCola;
            finalCola = nuevoNodo;
        }
        tamano++;
        actualizarTextArea(textArea);
    }

    public int desencolar(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía.");
            return -1;
        }
        int dato = frente.dato;
        frente = frente.siguiente;
        if (frente != null) {
            frente.anterior = null;
        } else {
            finalCola = null;
        }
        tamano--;
        actualizarTextArea(textArea);
        return dato;
    }

    public void invertirCola(JTextArea textArea) {
        if (estaVacia()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía. No se puede invertir.");
            return;
        }

        Nodo actual = frente;
        Nodo temp = null;

        while (actual != null) {
            temp = actual.anterior;
            actual.anterior = actual.siguiente;
            actual.siguiente = temp;
            actual = actual.anterior;
        }

        temp = frente;
        frente = finalCola;
        finalCola = temp;

        mostrarCola(textArea);
    }

    public boolean buscarElemento(int valor, JTextArea textArea) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.dato == valor) {
                textArea.setText("Elemento encontrado: " + valor);
                return true;
            }
            actual = actual.siguiente;
        }
        textArea.setText("Elemento no encontrado: " + valor);
        return false;
    }

    public void ordenarCola(boolean ascendente, JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía. No se puede ordenar.");
            return;
        }

        ArrayList<Integer> elementos = new ArrayList<>();
        Nodo actual = frente;
        while (actual != null) {
            elementos.add(actual.dato);
            actual = actual.siguiente;
        }

        if (ascendente) {
            Collections.sort(elementos);
        } else {
            Collections.sort(elementos, Collections.reverseOrder());
        }

        vaciarCola();
        for (int dato : elementos) {
            encolar(dato, null);
        }

        mostrarCola(textArea);
    }

    private void vaciarCola() {
        frente = null;
        finalCola = null;
        tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrarCola(JTextArea textArea) {
        if (estaVacia()) {
            textArea.setText("La cola está vacía.");
        } else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null) {
                colaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(colaStr.toString());
        }
    }

    private void actualizarTextArea(JTextArea textArea) {
        if (textArea != null) {
            mostrarCola(textArea);
        }
    }
}
