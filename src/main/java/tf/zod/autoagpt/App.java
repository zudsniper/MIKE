package tf.zod.autoagpt;

import javax.swing.*;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Auto-GPT Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setVisible(true);
        });

        AGPTInstanceManager agptInstanceManager = new AGPTInstanceManager();
        AGPTInstanceController agptInstanceController = new AGPTInstanceController();
        PluginManager pluginManager = new PluginManager();

        // Use the agptInstanceManager and pluginManager to manage Auto-GPT instances and plugins
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Auto-GPT Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            frame.add(agptInstanceController.getPanel());

            frame.setVisible(true);
        });


    }
    }
}