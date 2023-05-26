package tf.zod.autoagpt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class App {

    protected final static ClassLoader loader = Thread.currentThread().getContextClassLoader();

    public static Font jbFont;

    private static JFrame frame;

    public static void main(String[] args) throws IOException, FontFormatException {

        // obtain best font
        try (InputStream stream = loader.getResourceAsStream("fonts/JetBrainsMono-Medium.ttf")) {
            if (jbFont != null) {
                Font jbFont = Font.createFont(Font.TRUETYPE_FONT, jbFont);
            }
            System.out.println("The FONT didn't last...");
        }
    }


        AGPTInstanceController aGPTInstanceController = new AGPTInstanceController();

        PluginController pluginController = new PluginController();
        AGPTInstanceManager aGPTInstanceManager = new AGPTInstanceManager();
        AGPTInstanceController AGPTInstanceController = new AGPTInstanceController();
        PluginManager pluginManager = new PluginManager();

        // Use the agptInstanceManager and pluginManager to manage Auto-GPT instances and plugins
    frame = new JFrame("MIKE");

        SwingUtilities.invokeLater(() -> {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setSize(800, 600);
        frame.setFont(new Font(jbFont));

        frame.add(aGPTInstanceController.getPanel());
        //frame.add(AGPTInstanceController.getPanel());
        frame.add(pluginController.getPanel());
        //frame.add(pluginController.getPanel());

        frame.setVisible(true);
      };

    }
}