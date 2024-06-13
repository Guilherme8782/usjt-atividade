package menus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPrincipal extends JFrame {
    
    public MenuPrincipal() {
        setTitle("Projeto USJT - Case 04");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Layout FlowLayout com alinhamento central e espaçamento horizontal e vertical de 20 pixels
        
        JLabel label = new JLabel("Seja bem-vindo, escolha a estrutura de dados que deseja usar:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);
        
        JButton botaoFila = new JButton("Fila");
        JButton botaoPilha = new JButton("Pilha");
        JButton botaoLED = new JButton("Lista Duplamente Encadeada");
        
        // Define o tamanho preferido dos botões
        botaoFila.setPreferredSize(new Dimension(150, 30));
        botaoPilha.setPreferredSize(new Dimension(150, 30));
        botaoLED.setPreferredSize(new Dimension(150, 30));
        
        botaoFila.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaFila(MenuPrincipal.this);
            }
        });
        
        botaoPilha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaPilha(MenuPrincipal.this, 10);
            }
        });

        botaoLED.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
                MenuListaDuplamenteEncadeada menu = new MenuListaDuplamenteEncadeada(lista);
                menu.executar();
            }
        });
        
        panel.add(botaoFila);
        panel.add(botaoPilha);
        panel.add(botaoLED);
        
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal());
    }
}
