package menus;

import javax.swing.*;

import classes.Pilha;

import java.awt.*;
import java.awt.event.*;

public class TelaPilha extends JFrame {
    private Pilha pilha;
    private MenuPrincipal menuPrincipal;
    private JTextField inputField;

    public TelaPilha(MenuPrincipal menuPrincipal, int tamanhoMaximo) {
        this.menuPrincipal = menuPrincipal;
        pilha = new Pilha(tamanhoMaximo);

        setTitle("Pilha GUI");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JTextArea stackArea = new JTextArea();
        stackArea.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(new JScrollPane(stackArea), gbc);

        JLabel label = new JLabel("Número a ser adicionado:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        panel.add(label, gbc);

        inputField = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(inputField, gbc);

        JButton addButton = new JButton("Push");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int value = Integer.parseInt(inputField.getText());
                    pilha.push(value);
                    updateStackArea(stackArea);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TelaPilha.this, "Por favor, insira um número válido.");
                }
                inputField.setText("");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(addButton, gbc);

        JButton removeButton = new JButton("Pop");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    pilha.pop();
                    updateStackArea(stackArea);
                } catch (IllegalStateException ex) {
                    JOptionPane.showMessageDialog(TelaPilha.this, "A pilha está vazia.");
                }
            }
        });
        gbc.gridx = 1;
        panel.add(removeButton, gbc);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                menuPrincipal.setVisible(true); // Voltar para o MenuPrincipal
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(backButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateStackArea(JTextArea stackArea) {
        stackArea.setText("");
        Pilha tempPilha = new Pilha(pilha.array.length);
        while (!pilha.isEmpty()) {
            int elemento = pilha.pop();
            stackArea.append(elemento + "\n");
            tempPilha.push(elemento);
        }
        while (!tempPilha.isEmpty()) {
            pilha.push(tempPilha.pop());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPilha(null, 10); // Tamanho máximo da pilha
            }
        });
    }
}
