package menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListaDuplamenteEncadeada {

    private ListaDuplamenteEncadeada lista;
    private JComboBox<String> optionsComboBox;

    MenuListaDuplamenteEncadeada(ListaDuplamenteEncadeada lista) {
        this.lista = lista;
    }

    void executar() {
        JFrame frame = new JFrame("Menu Lista Duplamente Encadeada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Espaçamento entre os componentes

        String[] options = {"Inserir novo nó", "Remover último nó", "Mostrar conteúdo do nó atual",
                "Mostrar conteúdo do próximo nó", "Mostrar conteúdo do nó anterior", "Sair"};
        optionsComboBox = new JComboBox<>(options);
        optionsComboBox.setPreferredSize(new Dimension(220, 30));
        optionsComboBox.setMaximumSize(new Dimension(220, 30));

        JButton executeButton = new JButton("Executar");
        executeButton.setPreferredSize(new Dimension(220, 30));
        executeButton.setMaximumSize(new Dimension(220, 30));
        executeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String choice = (String) optionsComboBox.getSelectedItem();

                switch (choice) {
                    case "Inserir novo nó":
                        int item = Integer.parseInt(JOptionPane.showInputDialog("Digite o item a ser inserido:"));
                        lista.insert(item);
                        break;
                    case "Remover último nó":
                        lista.remover();
                        break;
                    case "Mostrar conteúdo do nó atual":
                        JOptionPane.showMessageDialog(frame, lista.itemAtual());
                        break;
                    case "Mostrar conteúdo do próximo nó":
                        JOptionPane.showMessageDialog(frame, lista.proxItem());
                        break;
                    case "Mostrar conteúdo do nó anterior":
                        JOptionPane.showMessageDialog(frame, lista.itemAnterior());
                        break;
                    case "Sair":
                        frame.dispose();
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Opção inválida!");
                }
            }
        });

        JButton backButton = new JButton("Voltar");
        backButton.setPreferredSize(new Dimension(220, 30)); // Mesmo tamanho do botão "Executar"
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Fecha a janela atual
                MenuPrincipal.main(new String[0]); // Volta ao MenuPrincipal
            }
        });

        // Adicionando o JComboBox
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(optionsComboBox, gbc);

        // Adicionando o botão "Executar"
        gbc.gridy = 1;
        panel.add(executeButton, gbc);

        // Adicionando o botão "Voltar"
        gbc.gridy = 2;
        panel.add(backButton, gbc);

        frame.add(panel);
        frame.setSize(300, 200); // Tamanho reduzido da janela
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        MenuListaDuplamenteEncadeada menu = new MenuListaDuplamenteEncadeada(lista);
        menu.executar();
    }
}

class ListaDuplamenteEncadeada {
    private No atual;

    ListaDuplamenteEncadeada() {
        this.atual = null;
    }

    void insert(int item) {
        No newNode = new No(item);
        if (atual == null) {
            atual = newNode;
        } else {
            newNode.anterior = atual;
            atual.proximo = newNode;
            atual = newNode;
        }
    }

    void remover() {
        if (atual != null) {
            atual = atual.anterior;
            if (atual != null)
                atual.proximo = null;
        }
    }

    String itemAtual() {
        if (atual != null) {
            return "Item atual: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }

    String proxItem() {
        if (atual != null && atual.proximo != null) {
            atual = atual.proximo;
            return "Próximo item: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }

    String itemAnterior() {
        if (atual != null && atual.anterior != null) {
            atual = atual.anterior;
            return "Item anterior: " + atual.item;
        } else {
            return "Lista Encerrada";
        }
    }
}

class No {
    int item;
    No anterior;
    No proximo;

    No(int item) {
        this.item = item;
        this.anterior = null;
        this.proximo = null;
    }
}
