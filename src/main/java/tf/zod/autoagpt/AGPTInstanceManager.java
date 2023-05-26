package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AGPTInstanceManager {
    private DockerCommandManager dockerCommandManager;

    public AGPTInstanceManager() {
        this.dockerCommandManager = new DockerCommandManager();
    }

    public void pauseInstance(String instanceName) {
        String command = "docker pause " + instanceName;
        dockerCommandManager.executeCommand(command);
    }

    public void exitInstance(String instanceName) {
        String command = "docker stop " + instanceName;
        dockerCommandManager.executeCommand(command);
    }

    public void saveInstance(String instanceName, String imageName) {
        String command = "docker commit " + instanceName + " " + imageName;
        dockerCommandManager.executeCommand(command);
    }

    public void copyInstance(String instanceName, String newImageName) {
        saveInstance(instanceName, newImageName);
    }
}
