package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;
import tf.zod.autoagpt.plugins.PluginController;
import tf.zod.autoagpt.plugins.PluginManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class App {

    protected final static ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public static Font jbFont;

    private static JFrame frame;

    public static void main(String[] args) throws IOException, FontFormatException {

        // obtain best font
        try (InputStream stream = loader.getResourceAsStream("/fonts/JetBrainsMono-Medium.ttf")) {
            if (jbFont == null && stream != null) {
                jbFont = Font.createFont(Font.TRUETYPE_FONT, stream);
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }


        // initialize and pack GUI

        AGPTInstanceController aGPTInstanceController = new AGPTInstanceController();

        PluginController pluginController = new PluginController();
        AGPTInstanceManager aGPTInstanceManager = new AGPTInstanceManager();
        AGPTInstanceController AGPTInstanceController = new AGPTInstanceController();
        PluginManager pluginManager = new PluginManager();

        SwingUtilities.invokeLater(() -> {

            // set look & feel
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.err.println("ERROR SETTING LOOK & FEEL");
                ex.printStackTrace();
            }

            JFrame frame = new JFrame("Auto-GPT Manager");

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            frame.add(AGPTInstanceController.getPanel());
            frame.add(pluginController.getPanel());

            frame.pack();

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}