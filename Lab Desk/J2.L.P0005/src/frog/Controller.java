package frog;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nghia
 */
public class Controller {

    private FrogGame f;
    private JButton btn1 = new JButton();
    private JButton btn2 = new JButton();
    private JButton btn3 = new JButton();
    private JButton btn4 = new JButton();
    private JButton btnFrog = new JButton();
    private Timer timer;
    private int point = 0;
    private Key key = new Key();
    boolean checkPause = false;
    boolean checkSave = false;

    public Controller(FrogGame f) {
        this.f = f;
        btnFrog.addKeyListener(key);
        f.getbtnPause().addKeyListener(key);
        f.getbtnSave().addKeyListener(key);
    }
    int x1 = 300;
    int h1 = 100;
    int x2 = 532;
    int h2 = 100;
    int h3 = 80;
    int h4 = 80;
    int yf = 50;

    //Function to add the frog and pipes 
    public void addButton() {
        btn1.setBounds(x1, 0, 40, h1);
        btn2.setBounds(x2, 0, 40, h2);
        btn3.setBounds(x1, 258 - h3, 40, h3);
        btn4.setBounds(x2, 258 - h4, 40, h4);
        //Add the frog and image
        btnFrog.setBounds(50, yf, 40, 40);
        btnFrog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frog/FrogImage.png")));
        f.frame.add(btn1);
        f.frame.add(btn2);
        f.frame.add(btn3);
        f.frame.add(btn4);
        f.frame.add(btnFrog);
    }

    //Function to check the frog die
    public boolean checkTouch() {
        if (yf <= 0 || yf >= 218) {
            return true;
        }
        //Check if the frog touch the pipe
        Rectangle btf = new Rectangle(btnFrog.getX(), btnFrog.getY(), btnFrog.getWidth(), btnFrog.getHeight());
        Rectangle bt1 = new Rectangle(btn1.getX(), btn1.getY(), btn1.getWidth(), btn1.getHeight());
        Rectangle bt2 = new Rectangle(btn2.getX(), btn2.getY(), btn2.getWidth(), btn2.getHeight());
        Rectangle bt3 = new Rectangle(btn3.getX(), btn3.getY(), btn3.getWidth(), btn3.getHeight());
        Rectangle bt4 = new Rectangle(btn4.getX(), btn4.getY(), btn4.getWidth(), btn4.getHeight());
        if (btf.intersects(bt1) || btf.intersects(bt2) || btf.intersects(bt3) || btf.intersects(bt4)) {
            return true;
        }
        return false;
    }

    //Function to pause/resume the game
    public void pause() {
        if (!checkPause) {
            timer.stop();
            checkPause = true;
        } else {
            timer.restart();
            checkPause = false;
        }
    }

    //Function to save point
    int x11, x22, h11, h22, h33, h44, yf1, point1;

    public void save() {
        checkSave = true;
        x11 = x1;
        x22 = x2;
        h11 = h1;
        h22 = h2;
        h33 = h3;
        h44 = h4;
        yf1 = yf;
        point1 = point;
    }

    //Function to count point
    public void countPoint() {
        if (btn1.getX() == 10 || btn2.getX() == 10) {
            point++;
            f.txtPoint.setText("Point:" + point);
        }
    }

    //Function to show message
    public void showMess() {
        String award = "No medal.";
        if (point > 10 && point < 20) {
            award = "Bronze medal.";
        } else if (point >= 20 && point < 30) {
            award = "Sliver medal";
        } else if (point >= 30) {
            award = "Gold medal";
        } else if (point >= 30) {
            award = "Platinum medal";
        }
        if (!checkSave) {
            Object mes[] = {"New Game", "Exit"};
            int option = JOptionPane.showOptionDialog(null, "You got " + award + " Do you want to continue?",
                    "Notice!",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, mes, mes[0]);
            //New game
            if (option == 0) {
                x1 = 300;
                h1 = 100;
                x2 = 532;
                h2 = 100;
                h3 = 80;
                h4 = 80;
                yf = 50;
                point = 0;
                f.txtPoint.setText("Point: 0");
                timer.restart();
            }
            //Exit
            if (option == 1) {
                System.exit(0);
            }
        } else {
            Object mes[] = {"New Game", "Countinue", "Exit"};
            int option = JOptionPane.showOptionDialog(null, "You got " + award + " Do you want to continue?",
                    "Notice!",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, mes, mes[0]);
            //New game
            if (option == 0) {
                x1 = 300;
                h1 = 100;
                x2 = 532;
                h2 = 100;
                h3 = 80;
                h4 = 80;
                yf = 50;
                point = 0;
                f.txtPoint.setText("Point: 0");
                timer.restart();
            }
            //Continue game
            if (option == 1) {
                x1 = x11;
                x2 = x22;
                h1 = h11;
                h2 = h22;
                h3 = h33;
                h4 = h44;
                yf = yf1;
                point = point1;
                f.txtPoint.setText("Poin: " + point);
                timer.restart();
            }
            //Exit game
            if (option == 2) {
                System.exit(0);
            }
        }
    }

    //Function to run the game
    public void run() {
        timer = new Timer(10, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addButton();
                x1--;
                x2--;
                yf++;
                //Set pipe1 and pipe3 to the right of the panel
                if (x1 == -40) {
                    x1 = 424;
                    Random r = new Random();
                    h1 = r.nextInt(30) + 70;
                    h3 = r.nextInt(30) + 70;
                }
                //Set pipe2 and pipe4 to the right of the panel
                if (x2 == -40) {
                    x2 = 424;
                    Random r = new Random();
                    h2 = r.nextInt(30) + 70;
                    h4 = r.nextInt(30) + 70;
                }
                //Move the frog up
                if (key.isPress()) {
                    yf = yf - 15;
                    key.setPress(false);
                }
                if (checkTouch()) {
                    timer.stop();
                    showMess();
                }
                countPoint();
            }
        });
        timer.start();
    }
}
