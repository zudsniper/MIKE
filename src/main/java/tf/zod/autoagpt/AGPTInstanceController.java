package tf.zod.autoagpt;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AGPTInstanceController {
    private AGPTInstanceManager AGPTInstanceManager;
    private JPanel panel;
    private JButton pauseButton;
    private JButton exitButton;
    private JButton saveButton;
    private JButton copyButton;

    private JComboBox<String> instanceComboBox;

    public AGPTInstanceController() {
        this.AGPTInstanceManager = new AGPTInstanceManager();

        // get the plugin list from plugin managers, show
        List<String> instances = AGPTInstanceManager.listInstances();
        instanceComboBox = new JComboBox<>(instances.toArray(new String[0]));

        // handle each button press with different functionality 
        pauseButton.addActionListener(e -> {
            String instanceName = (String) instanceComboBox.getSelectedItem();
            AGPTInstanceManager.pauseInstance(instanceName);
        });

        exitButton.addActionListener(e -> {
            String instanceName = (String) instanceComboBox.getSelectedItem();
            AGPTInstanceManager.exitInstance(instanceName);
        });

        saveButton.addActionListener(e -> {
            String instanceName = (String) instanceComboBox.getSelectedItem();
            // TODO: This doesn't make sense... why would we get it from the GUI? it's an isolated docker container
            String imageName = /* get the image name from the GUI */;
            AGPTInstanceManager.saveInstance(instanceName, imageName);
        });

        copyButton.addActionListener(e -> {
            String instanceName = (String) instanceComboBox.getSelectedItem();
            String newImageName = /* get the new image name from the GUI */;
            AGPTInstanceManager.copyInstance(instanceName, newImageName);
        });

    }

    public Component getPanel() {
        return panel;
    }
}
