import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainWindow extends JFrame {

    public static final int ERROR_MARGIN = 40;
    public final int BUTTON_WIDTH = 100;
    public final int BUTTON_HEIGHT = 50;

    private File fileToOpen;
    private boolean isGoodToGo;

    public MainWindow() {
        MainPanel panel = new MainPanel();
        this.setSize(panel.getBackgroundImage().getWidth(panel), panel.getBackgroundImage().getHeight(panel) + ERROR_MARGIN);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Image Process Project");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/iconforproject.png")).getImage());
        this.setVisible(true);
        this.setLayout(new BorderLayout());


        JButton start = new JButton("פתח תמונה");
       // start.setBounds((int) (this.getWidth() / 5) + MainWindow.ERROR_MARGIN, (int) (this.getHeight() / 2), BUTTON_WIDTH, BUTTON_HEIGHT);
        //this.add(start);
        this.add(start, BorderLayout.SOUTH);
        mainAction(start);
        //this.add(panel);
        this.add(panel, BorderLayout.CENTER);

    }

    public void mainAction(JButton start) {

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // צור JFileChooser
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select a file");

                // פתח את תיבת הבחירה והמתן לבחירת הקובץ
                int userSelection = fileChooser.showOpenDialog(null);

                // בדוק אם המשתמש בחר קובץ
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    fileToOpen = fileChooser.getSelectedFile();
                    // הצג את שם הקובץ שנבחר
                    JOptionPane.showMessageDialog(null, "Selected file: " + fileToOpen.getAbsolutePath());
                    isGoodToGo = true;
                }

                if (isGoodToGo) {
                    new ImageFrame(fileToOpen);
                    dispose();
                }
            }
        });


    }
}
