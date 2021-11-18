/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import gui.View;
import java.awt.Point;
import javax.swing.JOptionPane;

/**
 *
 * @author nghia
 */
public class Controller {

    View mFrame;
    int sizeMove;

    public Controller() {
        mFrame = new View();
        mFrame.setVisible(true);
        mFrame.setLocationRelativeTo(null);
        sizeMove = 5;

        mFrame.getBtnUp().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpActionPerformed(evt);
            }
        });
        mFrame.getBtnBottom().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBottomActionPerformed(evt);
            }
        });
        mFrame.getBtnLeft().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });
        mFrame.getBtnRight().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });
    }

    //Move up
    private void btnUpActionPerformed(java.awt.event.ActionEvent evt) {
        Point point = mFrame.getPanelCircle().getLocation();
        if (point.y - sizeMove > 0) {
            mFrame.getPanelCircle().setLocation(point.x, point.y - sizeMove);
        } else {
            JOptionPane.showMessageDialog(mFrame, "Can not go up");
        }
    }

    //Move bottom
    private void btnBottomActionPerformed(java.awt.event.ActionEvent evt) {
        Point point = mFrame.getPanelCircle().getLocation();
        double limit = mFrame.getContentPane().getSize().getHeight()
                - mFrame.getjPanel1().getSize().getHeight();
        double localCircle = point.y + mFrame.getPanelCircle().getSize().getHeight();
        if (limit > localCircle + sizeMove) {
            mFrame.getPanelCircle().setLocation(point.x, point.y + sizeMove);
        }
        else {
            JOptionPane.showMessageDialog(mFrame, "Can not go bottom");
        }
    }

    //Move left
    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {
        Point point = mFrame.getPanelCircle().getLocation();
        if (point.x > 0) {
            mFrame.getPanelCircle().setLocation(point.x - sizeMove, point.y);
        }
        else {
            JOptionPane.showMessageDialog(mFrame, "Can not go left");
        }
    }

    //Move right
    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {
        Point point = mFrame.getPanelCircle().getLocation();
        double limit = mFrame.getContentPane().getSize().getWidth();
        double localCircle = point.x + mFrame.getPanelCircle().getSize().getWidth();
        if (limit > localCircle) {
            mFrame.getPanelCircle().setLocation(point.x + sizeMove, point.y);
        }
        else {
            JOptionPane.showMessageDialog(mFrame, "Can not go right");
        }
    }
}
