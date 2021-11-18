/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Nghia
 */
public class ImageTool {

    public ArrayList<javax.swing.ImageIcon> arrImg = new ArrayList<>();
    public final int image1 = 0;
    public final int image2 = 1;
    public final int image3 = 2;
    public final int image4 = 3;
    public final int image5 = 4;
    ImageIcon ii;

    public ImageTool(ImageIcon ii) {
        this.ii = ii;
    }

    public void loadImageToArray() {
        File folder = new File("images");
        File[] imgs = folder.listFiles();
        for (File i : imgs) {
            javax.swing.ImageIcon ii = new javax.swing.ImageIcon("images/" + i.getName());
            arrImg.add(ii);
        }
    }

    public void addImgToBtn(javax.swing.ImageIcon image, JButton btn) {
        Image i = image.getImage().getScaledInstance(
                btn.getWidth() - 10, btn.getHeight(), Image.SCALE_SMOOTH);
        btn.setIcon(new javax.swing.ImageIcon(i));
    }

    public void addImgToLb(javax.swing.ImageIcon image, JLabel lb) {
        Image i = image.getImage().getScaledInstance(
                ii.getWidth(), ii.getHeight() - 120, Image.SCALE_SMOOTH);
        lb.setIcon(new javax.swing.ImageIcon(i));
    }

    public void setButton() {
        addImgToBtn(arrImg.get(image1), ii.getBtn1());
        addImgToBtn(arrImg.get(image2), ii.getBtn2());
        addImgToBtn(arrImg.get(image3), ii.getBtn3());
        addImgToBtn(arrImg.get(image4), ii.getBtn4());
        addImgToBtn(arrImg.get(image5), ii.getBtn5());
    }
}
