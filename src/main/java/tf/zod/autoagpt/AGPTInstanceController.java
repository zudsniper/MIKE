package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public class AGPTInstanceController {
    private AGPTInstanceManager AGPTInstanceManager;
    private JPanel panel;
    private JButton pauseButton;
    private JButton exitButton;
    private JButton saveButton;
    private JButton copyButton;

    private JComboBox<String> instanceComboBox;

    public AGPTInstanceController(tf.zod.autoagpt.AGPTInstanceManager AGPTInstanceManager) {
        this.AGPTInstanceManager = AGPTInstanceManager;
    }

    public AGPTInstanceController() {

        this.AGPTInstanceManager = new AGPTInstanceManager();

        // create the panel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        // create the buttons
        pauseButton = new JButton("Pause");
        exitButton = new JButton("Exit");
        saveButton = new JButton("Save");
        copyButton = new JButton("Copy");

        // add the buttons to the panel
        panel.add(pauseButton);
        panel.add(exitButton);
        panel.add(saveButton);
        panel.add(copyButton);

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
            String imageName = null /* get the image name from the GUI */;
            AGPTInstanceManager.saveInstance(instanceName, imageName);
        });

        copyButton.addActionListener(e -> {
            String instanceName = (String) instanceComboBox.getSelectedItem();
            String newImageName = null /* get the new image name from the GUI */;
            AGPTInstanceManager.copyInstance(instanceName, newImageName);
        });

    }

    public Component getPanel() {
        return panel;
    }
}
