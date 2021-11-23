package edu.info.ip.util;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ContrastExpandDlg extends AbstractSettingsDialog{

    private JSlider slider1;
    private JTextField textField1;

    public ContrastExpandDlg() {
        super();
        setTitle("Expandare contrast");

        mainPanel.setLayout(new GridLayout(1,1));

        JPanel panel1 = new JPanel();
        textField1 = new JTextField(5);
        slider1 = new JSlider(-0,5,0);

        slider1.setPreferredSize(new Dimension(400,50));
       slider1.setMajorTickSpacing(1);
     // slider1.setMinorTickSpacing(0.1);
        slider1.setPaintLabels(true);
        slider1.setPaintTicks(true);

        panel1.add(textField1);
        panel1.add(slider1);

        mainPanel.add(panel1);

        slider1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                onSlide();
            }
        });
    }

    private void onSlide(){
        int val = slider1.getValue();
        textField1.setText(""+val);

        BufferedImage img = ImageUtil.contrastExpandare(originalImg, val);
        imagePanel.setImage(img);
    }
}
