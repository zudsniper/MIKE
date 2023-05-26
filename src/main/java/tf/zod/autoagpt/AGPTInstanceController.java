package tf.zod.autoagpt;

import javax.swing.*;
import java.awt.*;

public class AGPTInstanceController {
    private AGPTInstanceManager AGPTInstanceManager;
    private JPanel panel;
    private JButton pauseButton;
    private JButton exitButton;
    private JButton saveButton;
    private JButton copyButton;

    public AGPTInstanceController() {
        this.AGPTInstanceManager = new AGPTInstanceManager();

        // TODO: This will result in a nullpointerexception -- resolve this or handle the exception
        pauseButton.addActionListener(e -> AGPTInstanceManager.pauseInstance("instanceName"));
        exitButton.addActionListener(e -> AGPTInstanceManager.exitInstance("instanceName"));
        saveButton.addActionListener(e -> AGPTInstanceManager.saveInstance("instanceName", "imageName"));
        copyButton.addActionListener(e -> AGPTInstanceManager.copyInstance("instanceName", "newImageName"));
    }

    public Component getPanel() {
        return panel;
    }
}
