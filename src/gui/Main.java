package gui;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        try {
        // Aplica o tema FlatLaf
        UIManager.setLookAndFeel(new FlatLightLaf());


        // Cor das linhas alternadas (zebradas)
        UIManager.put("Table.alternateRowColor", new Color(244,244,244)); 

        // Cor da linha selecionada
        UIManager.put("Table.selectionBackground", new Color(255, 204, 128)); 
        UIManager.put("sFont", new Font("Segoe UI", Font.PLAIN, 13));

        // Cor das linhas
        UIManager.put("Table.showHorizontalLines", true);
        UIManager.put("Table.showVerticalLines", false);
        UIManager.put("Table.gridColor", new Color(224, 224, 224));

        // Cabeçalho centralizado
        UIManager.put("TableHeader.centerTableColumnLabels", true);

        // Margem compacta entre células
        UIManager.put("Table.intercellSpacing", new Dimension(0, 1));

        // Fonte moderna (opcional)
        UIManager.put("defaultFont", new Font("Segoe UI", Font.PLAIN, 13));
        UIManager.put("Button.arc", 10); 
        UIManager.put("Button.borderWidth", 1.5); 
        UIManager.put("Button.borderColor", new Color(0, 0, 0));
        UIManager.put("TextComponent.arc", 10);
        UIManager.put("Button.hoverBackground", new Color(255, 204, 128));
        UIManager.put("Button.hoverBorderColor", new Color(0, 0, 0));
        UIManager.put("Button.pressedBackground", new Color(255, 171, 64));
        UIManager.put("Button.focusedBackground", new Color(255,204,128));
        UIManager.put("Button.focusedBorderColor", new Color(0, 0, 0));
        
        UIManager.put("Button.default.arc", UIManager.get("Button.arc"));
        UIManager.put("Button.default.borderWidth", UIManager.get("Button.borderWidth"));
        UIManager.put("Button.default.borderColor", UIManager.get("Button.borderColor"));
        UIManager.put("Button.default.hoverBackground", UIManager.get("Button.hoverBackground"));
        UIManager.put("Button.default.hoverBorderColor", UIManager.get("Button.hoverBorderColor"));
        UIManager.put("Button.default.pressedBackground", UIManager.get("Button.pressedBackground"));
        UIManager.put("Button.default.focusedBackground", UIManager.get("Button.focusedBackground"));
        UIManager.put("Button.default.focusedBorderColor", UIManager.get("Button.focusedBorderColor"));
        
            
        } catch (UnsupportedLookAndFeelException e) {
            System.err.println("Erro ao aplicar FlatLaf: " + e.getMessage());
        }

        // Inicia a tela principal
        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
}
