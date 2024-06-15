import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel extends JPanel {

    private Image backgroundImage;

    public MainPanel() {

        this.backgroundImage = new ImageIcon(getClass().getResource("/Images/background.png")).getImage();
        System.out.println(this.backgroundImage.getHeight(this));
        this.setPreferredSize(new Dimension(this.backgroundImage.getWidth(this), this.getBackgroundImage().getHeight(this)));
        this.setBounds(0, 1, this.backgroundImage.getWidth(this), this.backgroundImage.getHeight(this));
        this.setLayout(null);


    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.backgroundImage, 0, 0, this);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Image process Project", (this.getWidth() / 3) - MainWindow.ERROR_MARGIN, 50);
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }
}
