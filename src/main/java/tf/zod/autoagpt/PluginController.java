package tf.zod.autoagpt;

import tf.zod.autoagpt.model.*;


import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class PluginController {
    /**
     * This plugin controller must have access to essentially all processes for each docker container.
     */
    private PluginManager pluginManager;
    private PluginInstaller pluginInstaller;
    private PluginList pluginList;
    private JPanel panel;
    private JButton installButton;
    private JComboBox<Plugin> pluginComboBox;

    public PluginController() {
        this.pluginManager = new PluginManager();
        this.pluginInstaller = new PluginInstaller();
        this.pluginList = new PluginList();

        List<Plugin> plugins = pluginList.loadPlugins();
        pluginComboBox = new JComboBox<>(plugins.toArray(new Plugin[0]));

        installButton.addActionListener(e -> {
            Plugin plugin = (Plugin) pluginComboBox.getSelectedItem();
            pluginInstaller.installPlugin(Objects.requireNonNull(plugin));
        });
    }

    public JPanel getPanel() {
        return panel;
    }
}
