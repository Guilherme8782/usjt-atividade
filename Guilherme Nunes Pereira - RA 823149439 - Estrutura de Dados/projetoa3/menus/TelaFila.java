package menus;


import javax.swing.*;

import classes.Fila;

import java.awt.*;
import java.awt.event.*;

public class TelaFila extends JFrame {

    private Fila fila;
    private MenuPrincipal menuPrincipal;
    private JComboBox<String> optionsComboBox;

    public TelaFila(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        fila = new Fila();
        setTitle("Tela da Fila");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Adiciona margens entre os componentes

        JLabel label = new JLabel("Operações na Fila:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(label, gbc);

        String[] options = {"Inserir Elemento (A)", "Consultar Primeiro Elemento (B)", "Retirar Elemento (C)", "Consultar Fila Completa (D)"};
        optionsComboBox = new JComboBox<>(options);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(optionsComboBox, gbc);

        JButton confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) optionsComboBox.getSelectedItem();
                char choice = selectedOption.charAt(selectedOption.length() - 2); // Pega a letra da opção selecionada

                switch (choice) {
                    case 'A':
                        int inserir = Integer.parseInt(JOptionPane.showInputDialog("Digite o número que deseja inserir:"));
                        fila.enQueue(inserir);
                        break;
                    case 'B':
                        if (fila.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Fila está vazia");
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Primeiro elemento: " + fila.front());
                        break;
                    case 'C':
                        if (fila.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Fila está vazia");
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Retirando o primeiro elemento.");
                        fila.deQueue();
                        break;
                    case 'D':
                        if (fila.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Fila está vazia");
                            break;
                        }
                        JOptionPane.showMessageDialog(null, "Fila: " + fila.allList());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida.");
                        break;
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(confirmButton, gbc);

        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                menuPrincipal.setVisible(true); // Voltar para o MenuPrincipal
            }
        });
        gbc.gridx = 1;
        panel.add(backButton, gbc);

        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TelaFila(null)); // A referência a MenuPrincipal será passada quando criada a instância de TelaFila no MenuPrincipal
    }
}
