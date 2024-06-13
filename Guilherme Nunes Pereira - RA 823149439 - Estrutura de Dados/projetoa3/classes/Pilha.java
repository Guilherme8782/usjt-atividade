package classes;

import javax.swing.JOptionPane;

public class Pilha {
    public Integer[] array; // Array para armazenar os elementos da pilha
    private int topo; // Índice do topo da pilha

    public Pilha(int tamanhoMaximo) {
        array = new Integer[tamanhoMaximo];
        topo = -1;
    }

    // Método para inserir um elemento no topo da pilha
    public void push(Integer elemento) {
        if (topo == array.length - 1) {
            JOptionPane.showMessageDialog(null, "Elemento: Pilha está cheia");
        }
    
        topo++;
        array[topo] = elemento;
    }

    // Método para remover e retornar o elemento no topo da pilha
    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        Integer elemento = array[topo];
        array[topo] = null; // Libera a referência para o objeto removido
        topo--;
        return elemento;
    }
    // Método para verificar se a pilha está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // Método para acessar o elemento no topo da pilha sem removê-lo
    public Integer peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return array[topo];
    }

    // Método para imprimir os elementos da pilha
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Pilha vazia");
            return;
        }
        System.out.print("Pilha: ");
        for (int i = topo; i >= 0; i--) {
            JOptionPane.showMessageDialog(null, "Elemento: " + array[i]);
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
