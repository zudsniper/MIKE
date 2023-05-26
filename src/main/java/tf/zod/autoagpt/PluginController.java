package tf.zod.autoagpt;

import javax.swing.*;

public class PluginController {
    private PluginManager pluginManager;
    private JPanel panel;
    private JButton installButton;

    public PluginController() {
        this.pluginManager = new PluginManager();

        installButton.addActionListener(e -> pluginManager.installPlugins());
    }

    public JPanel getPanel() {
        return panel;
    }
}
