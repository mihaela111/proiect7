package edu.info.ip.util;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageUtil {

    public static BufferedImage loadImage(String fileName) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static void saveImage(BufferedImage img, String fileName, String fileType) {
        try {
            ImageIO.write(img, fileType, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void displayImage(BufferedImage img, String title) {
        if (img == null)
            return;
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setFitToScreen(false);
        imagePanel.setImage(img);
        frame.setContentPane(new JScrollPane(imagePanel));
        frame.pack();
        frame.setVisible(true);
    }

    public static void displayImage(BufferedImage img) {
        displayImage(img, "");
    }

    public static BufferedImage generateRandom(int width, int height) {
        BufferedImage img = null;

        img = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
        Random random = new Random();

        for (int y = 0; y < img.getHeight(); y++)
            for (int x = 0; x < img.getWidth(); x++) img.getRaster().setSample(x, y, 0, random.nextInt(256));
        return img;
    }

    public static BufferedImage extractBand(BufferedImage inImg, char band) {
        BufferedImage outImg = new BufferedImage(inImg.getWidth(), inImg.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < inImg.getHeight(); y++)
            for (int x = 0; x < inImg.getWidth(); x++) {
                int pixel = inImg.getRGB(x, y);

                int alpha = (pixel & 0xff000000) >> 24; //(pixel >> 24) & 0xff;
                int red = (pixel & 0x00ff0000) >> 16; //(pixel >> 16) & 0xff;
                int green = (pixel & 0x0000ff00) >> 8;  //(pixel >> 8) & 0xff;
                int blue = (pixel & 0x000000ff);       //pixel & 0xff;

                if (y == 0)
                    System.out.print(alpha + " " + red + " " + green + " " + blue + " ; ");
//                outImg.setRGB(x,y,blue);
                switch (band) {
                    case 'R' -> {
                        outImg.getRaster().setSample(x, y, 0, red);
                    }
                    case 'G' -> {
                        outImg.getRaster().setSample(x, y, 0, green);
                    }
                    case 'B' -> {
                        outImg.getRaster().setSample(x, y, 0, blue);
                    }
                    case 'A' -> {
                        outImg.getRaster().setSample(x, y, 0, alpha);
                    }
                }

            }
        return outImg;
    }

    public static BufferedImage extractBandV2(BufferedImage inImg, int band) {
        BufferedImage outImg = new BufferedImage(inImg.getWidth(), inImg.getHeight(), BufferedImage.TYPE_BYTE_GRAY);

        for (int y = 0; y < inImg.getHeight(); y++)
            for (int x = 0; x < inImg.getWidth(); x++) {
                int val = inImg.getRaster().getSample(x, y, band);
                outImg.getRaster().setSample(x, y, 0, val);
            }

        return outImg;
    }

    public static BufferedImage flipH(BufferedImage inImg){
        BufferedImage outImg = new BufferedImage(inImg.getWidth(), inImg.getHeight(), inImg.getType());

        for (int y = 0; y < inImg.getHeight(); y++)
            for (int x = 0; x < inImg.getWidth()/2; x++) {
//                int pixel = inImg.getRGB(x,y);
                outImg.setRGB(x,y, inImg.getRGB((inImg.getWidth()-1)-x,y));
                outImg.setRGB((inImg.getWidth()-1)-x,y,inImg.getRGB(x,y));
            }

        return outImg;
    }

    public static BufferedImage flipV(BufferedImage inImg){
        BufferedImage outImg = new BufferedImage(inImg.getWidth(), inImg.getHeight(), inImg.getType());

        for (int y = 0; y < inImg.getHeight()/2; y++)
            for (int x = 0; x < inImg.getWidth(); x++) {
//                int pixel = inImg.getRGB(x,y);
                outImg.setRGB(x,y, inImg.getRGB(x,inImg.getHeight()-1-y));
                outImg.setRGB(x,inImg.getHeight()-1-y,inImg.getRGB(x,y));
            }
        return outImg;
    }

    public static BufferedImage simpleSaltPepperNoise(BufferedImage inImg, double amount) {
        BufferedImage outImg = new BufferedImage(inImg.getWidth(), inImg.getHeight(), inImg.getType());

        double low = amount;
        double high = 1.0 - amount;

        for (int y = 0; y < inImg.getHeight(); y++)
            for (int x = 0; x < inImg.getWidth(); x++) {
                double noiseLevel = Math.random();

                if (noiseLevel <= low)
                    for (int band = 0; band < inImg.getRaster().getNumBands() && band < 3; band++)
                        outImg.getRaster().setSample(x, y, band, 0);
                else if (noiseLevel >= high)
                    for (int band = 0; band < inImg.getRaster().getNumBands() && band < 3; band++)
                        outImg.getRaster().setSample(x, y, band, 255);
                else
                    for (int band = 0; band < inImg.getRaster().getNumBands() && band < 3; band++)
                        outImg.getRaster().setSample(x, y, band, inImg.getRaster().getSample(x, y, band));
            }
        return outImg;
    }
}
