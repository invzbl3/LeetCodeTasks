package com.task.algorithm.Medium.solved;

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT
 * allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 * Example 2:
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 * Constraints:
 *
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 *
 */
// Java program to rotate image by 90 degrees clockwise

// Importing classes from java.awt package for
// painting graphics and images
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
// Importing input output classes
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

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