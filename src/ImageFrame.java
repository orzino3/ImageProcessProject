import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageFrame extends JFrame {
    public ImageFrame(File fileToProcess) {

        if (fileToProcess.exists()) {
            try {
                BufferedImage bufferedImage = ImageIO.read(fileToProcess);
                ImagePanel displayImage = new ImagePanel(bufferedImage);

                // יצירת JComboBox עם הפריטים
                String[] filters = {"בחר פילטר", "תמונה מקורית", "Negative", "Draw Borders","Gray Scale","Tint","Posterize"};
                JComboBox<String> filterBox = new JComboBox<>(filters);

                // הוספת ActionListener ל-JComboBox
                filterBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String selectedItem = (String) filterBox.getSelectedItem();
                        if (selectedItem!=null) {
                            switch (selectedItem) {
                                case "תמונה מקורית":
                                    displayImage.showOriginal();
                                    break;
                                case "Negative":
                                    displayImage.applyNegative();
                                    break;
                                case "Draw Borders":
                                    displayImage.applyDrawBorders();
                                    break;

                                case "Gray Scale":
                                    displayImage.applyGrayScale();
                                    break;

                                case "Tint":
                                    displayImage.applyTint();
                                    break;

                                case "Posterize":
                                    displayImage.applySketch();
                                    break;
                            }
                        }
                    }
                });

                // הוספת JComboBox ו-ImagePanel ל-JFrame
                this.setLayout(new BorderLayout());
                this.add(filterBox, BorderLayout.NORTH);
                this.add(displayImage, BorderLayout.CENTER);
                this.setTitle("Image Process Project");
                this.setIconImage(new ImageIcon(getClass().getResource("/Images/iconforproject.png")).getImage());
                this.setLocationRelativeTo(null);

                this.pack();
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setVisible(true);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File does not exist: " + fileToProcess.getAbsolutePath());
        }
    }

}
