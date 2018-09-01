import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class FeedTheCatSwing extends JFrame {
    final String TITLE_OF_PROGRAM = "Feed The Cat";
    final int WINDOW_WIDTH = 600;
    final int WINDOW_HEIGHT = 600;

    public static void main(String[] args) throws IOException{
        new FeedTheCatSwing();
    }

    public FeedTheCatSwing() throws IOException{
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        ImageIcon icon = new ImageIcon("src\\img\\simon_icon.jpg");
        setIconImage(icon.getImage());

        Plate plate = new Plate(50);
        FeedTheCat feedTheCat = new FeedTheCat();
        Cat[] cats = feedTheCat.callCats(12);
        CatButton[] catButtons = new CatButton[cats.length];

        setLayout(null);
        JPanel panelButtons = new JPanel();

        panelButtons.setLayout(new FlowLayout());

        JLabel txtLabel2 = new JLabel();
        txtLabel2.setText(plate.toString());
        txtLabel2.setBounds(5, WINDOW_HEIGHT - 250, WINDOW_WIDTH, 50);

        for(int i = 0; i < catButtons.length; i++){
            catButtons[i] = new CatButton(cats[i], plate, txtLabel2);
            panelButtons.add(catButtons[i]);
        }

        ImageIcon plateIcon = new ImageIcon("src\\img\\simon_plate.jpg");

        JButton plateButton = new JButton("", plateIcon);
        plateButton.setBounds(150, 400, 300, 148);
        plateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                plate.addFood(5);
                txtLabel2.setText(plate.toString());
            }
        });
        plateButton.setBorderPainted(false);

        JLabel txtLabel = new JLabel();
        txtLabel.setText("Нажмине на кота чтобы покормить его. Нажмите на тарелку чтобы добавить еды.");
        txtLabel.setBounds(5, WINDOW_HEIGHT - 70, WINDOW_WIDTH, 50);

        panelButtons.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT - 250);
        panelButtons.setBackground(Color.white);
        add(panelButtons);
        add(plateButton);
        add(txtLabel);
        add(txtLabel2);

        setVisible(true);
    }
}

class CatButton extends JButton {
    ImageIcon hungryIcon = new ImageIcon("src\\img\\hungry.jpg");
    ImageIcon happyIcon = new ImageIcon("src\\img\\happy.jpg");
    Cat cat;
    Plate plate;
    CatButton(Cat cat, Plate plate, JLabel label) {
        this.cat = cat;
        this.plate = plate;
        setBackground(Color.white);
        if(cat.isHungry()) {
            setIcon(hungryIcon);
        } else {
            setIcon(happyIcon);
        }

        setFocusPainted(false);

        addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (cat.isHungry()) {
                    cat.eat(plate);
                }

                if(cat.isHungry()) {
                    setIcon(hungryIcon);
                } else {
                    setIcon(happyIcon);
                }
                label.setText(plate.toString());
            }
        });
    }
}