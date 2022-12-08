package com.task.algorithm.Medium.solved;

// Java program to rotate image by 90 degrees clockwise

// Importing classes from java.awt package for
// painting graphics and images
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
// Importing input output classes
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author invzbl3 on 12/4/2022
 * @project LeetCodeTask
 */

// Main class
public class RotateImage {

    // Method 1
    // To return rotated image
    public static BufferedImage rotate(BufferedImage img) {

        // Getting Dimensions of image
        int width = img.getWidth();
        int height = img.getHeight();

        // Creating a new buffered image
        BufferedImage newImage = new BufferedImage(
                img.getWidth(), img.getHeight(), img.getType());

        // creating Graphics in buffered image
        Graphics2D g2 = newImage.createGraphics();

        // Rotating image by degrees using toradians()
        // method
        // and setting new dimension t it
        g2.rotate(Math.toRadians(90), width / 2,
                height / 2);
        g2.drawImage(img, null, 0, 0);

        // Return rotated buffer image
        return newImage;
    }

    // Method 2
    // Main driver method
    public static void main(String[] args) {
        // try block to check for exceptions
        try {

            // Reading original image
            BufferedImage originalImg = ImageIO.read(
                    new File("E:\\test_photo\\1.jpg"));

            // Getting and Printing dimensions of original
            // image
            System.out.println("Original Image Dimension: "
                    + originalImg.getWidth() + "x"
                    + originalImg.getHeight());

            // Creating a subimage of given dimensions
            BufferedImage SubImg = rotate(originalImg);

            // Printing Dimensions of new image created
            // (Rotated image)
            System.out.println("Cropped Image Dimension: "
                    + SubImg.getWidth() + "x"
                    + SubImg.getHeight());

            // Creating new file for rotated image
            File outputfile
                    = new File("E:\\test_photo\\ImageRotated.jpeg");

            // Writing image in new file created
            ImageIO.write(SubImg, "jpg", outputfile);

            // Printing executed message
            System.out.println(
                    "Image rotated successfully: "
                            + outputfile.getPath());
        }

        // Catch block to handle the exception
        catch (IOException e) {
            // Print the line number where exception
            // occurred
            e.printStackTrace();
        }
    }
}