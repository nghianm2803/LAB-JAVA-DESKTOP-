/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawCircle;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author nghia
 */
public class Acircle extends JPanel {

    int arc;
    Color color;

    public Acircle(int arc, Color bgColor) {
        this.arc = arc;
        color = bgColor;
    }

    @Override
    public void paint(Graphics g) {
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics.setColor(color);
            graphics.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);
    }
}
