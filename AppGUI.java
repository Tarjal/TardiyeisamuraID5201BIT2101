import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class AppGUI extends JFrame {

    private JLabel displayLabel;
    private JButton updateTextButton;
    private JButton updateBgButton;
    private JPanel contentPanel;

    public AppGUI() {
        // Window Initialization
        setTitle("Java Swing Assignment");
        setSize(new Dimension(800, 800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Load Application Icon
        configureIcon();

        // Main Panel with BorderLayout
        contentPanel = new JPanel(new BorderLayout(20, 20));
        contentPanel.setBackground(new Color(245, 245, 250));

        // Display Heading
        displayLabel = new JLabel(
            "Welcome to Java Swing First Individual Assignment by Tardi Yei Samura", 
            SwingConstants.CENTER
        );
        displayLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        displayLabel.setForeground(new Color(40, 40, 50));

        // Buttons
        updateTextButton = new JButton("Change Text");
        updateBgButton = new JButton("Change Background");

        updateTextButton.setFocusable(false);
        updateBgButton.setFocusable(false);

        // Event Handling via Lambda Expressions
        updateTextButton.addActionListener(e -> 
            displayLabel.setText("Text updated! Event Driven Programming in Java Swing.")
        );

        updateBgButton.addActionListener(e -> 
            contentPanel.setBackground(new Color(139, 75, 139)) // Soft Ice Blue
        );

        // Button Layout Container
        JPanel actionContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        actionContainer.setOpaque(false);
        actionContainer.add(updateTextButton);
        actionContainer.add(updateBgButton);

        // Component Assembly
        JPanel centerWrapper = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
        centerWrapper.setOpaque(false);
        centerWrapper.add(displayLabel);
        centerWrapper.add(actionContainer);

        contentPanel.add(centerWrapper, BorderLayout.CENTER);
        add(contentPanel);
    }

    private void configureIcon() {
        try {
            String iconPath = "resources/download - 2026-04-06T140256.614.jpeg";
            File iconFile = new File(iconPath);
            if (iconFile.exists()) {
                ImageIcon imgIcon = new ImageIcon(iconFile.getAbsolutePath());
                setIconImage(imgIcon.getImage());
            } else {
                System.err.println("Icon not found at: " + iconFile.getAbsolutePath());
            }
        } catch (Exception err) {
            System.err.println("Icon path unreadable: " + err.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppGUI().setVisible(true);
        });
    }
}