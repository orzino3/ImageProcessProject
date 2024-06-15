import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private BufferedImage originalImage;

    public ImagePanel(BufferedImage image) {
        this.originalImage = image;
        this.image = cloneImage(image);

        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    public void showOriginal() {
        this.image = cloneImage(originalImage);
        repaint();
    }

    public void applyNegative() {
        this.image = negative(cloneImage(originalImage));
        repaint();
    }

    public void applyDrawBorders() {
        this.image = drawBorders(cloneImage(originalImage));
        repaint();
    }

    public void applyGrayScale(){
        this.image = grayScale(cloneImage(originalImage));
        repaint();
    }

    public void applyTint(){
        this.image = tintImage(cloneImage(originalImage));
        repaint();
    }

    public void applySketch(){
        this.image = sketch(cloneImage(originalImage));
        repaint();
    }

    private BufferedImage negative(BufferedImage bufferedImage) {
        for (int x = 0; x < bufferedImage.getWidth(); x++) {
            for (int y = 0; y < bufferedImage.getHeight(); y++) {
                Color currentColor = new Color(bufferedImage.getRGB(x, y));
                int red = 255 - currentColor.getRed();
                int green = 255 - currentColor.getGreen();
                int blue = 255 - currentColor.getBlue();
                Color updatedColor = new Color(red, green, blue);
                bufferedImage.setRGB(x, y, updatedColor.getRGB());
            }
        }
        return bufferedImage;
    }

    private BufferedImage drawBorders(BufferedImage bufferedImage) {
        int threshold = 70;
        for (int x = 0; x < bufferedImage.getWidth() - 1; x++) {
            for (int y = 0; y < bufferedImage.getHeight() - 1; y++) {
                boolean border = false;
                Color currentPixel = new Color(bufferedImage.getRGB(x, y));
                Color rightNeighbor = new Color(bufferedImage.getRGB(x + 1, y));
                int redDiff = Math.abs(currentPixel.getRed() - rightNeighbor.getRed());
                int greenDiff = Math.abs(currentPixel.getGreen() - rightNeighbor.getGreen());
                int blueDiff = Math.abs(currentPixel.getBlue() - rightNeighbor.getBlue());
                int totalDiff = redDiff + greenDiff + blueDiff;
                if (totalDiff > threshold) {
                    border = true;
                } else {
                    Color downNeighbor = new Color(bufferedImage.getRGB(x, y + 1));
                    redDiff = Math.abs(currentPixel.getRed() - downNeighbor.getRed());
                    greenDiff = Math.abs(currentPixel.getGreen() - downNeighbor.getGreen());
                    blueDiff = Math.abs(currentPixel.getBlue() - downNeighbor.getBlue());
                    totalDiff = redDiff + greenDiff + blueDiff;
                    if (totalDiff > threshold) {
                        border = true;
                    }
                }
                if (border) {
                    bufferedImage.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    bufferedImage.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return bufferedImage;
    }

    private BufferedImage grayScale(BufferedImage bufferedImage){

        for (int x = 0; x < bufferedImage.getWidth()-1; x++) {
            for (int y = 0; y < bufferedImage.getHeight()-1; y++) {
                int colorCode = bufferedImage.getRGB(x, y);
                Color color = new Color(colorCode);
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                Color newColor = new Color(average, average, average);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }

        return bufferedImage;
    }

    private BufferedImage tintImage(BufferedImage bufferedImage){

        for (int x = 0; x < bufferedImage.getWidth()-1; x++) {
            for (int y = 0; y < bufferedImage.getHeight()-1; y++) {
                int colorCode = bufferedImage.getRGB(x, y);
                Color color = new Color(colorCode);
                int average = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                Color newColor = new Color(255, average, average);
                bufferedImage.setRGB(x, y, newColor.getRGB());
            }
        }

        return bufferedImage;
    }

    private BufferedImage sketch(BufferedImage bufferedImage) {
        grayScale(bufferedImage);
        negative(bufferedImage);


        return bufferedImage;

    }

    private BufferedImage cloneImage(BufferedImage image) {
        BufferedImage clone = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g2d = clone.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();
        return clone;
    }
}
