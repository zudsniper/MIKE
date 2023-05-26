package tf.zod.autoagpt;


import java.util.List;
import java.util.stream.Collectors;

public class AGPTInstanceManager {

    private DockerCommandManager dockerCommandManager;
    private DockerImageManager dockerImageManager;

    public AGPTInstanceManager() {
        this.dockerCommandManager = new DockerCommandManager();
        this.dockerImageManager = new DockerImageManager();
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
        dockerImageManager.saveImage(instanceName, imageName);
    }

    public void copyInstance(String instanceName, String newImageName) {
        dockerImageManager.saveImage(instanceName, newImageName);
        dockerImageManager.loadImage(newImageName);
    }

    public List<String> listInstances() {
        List<String> containers = dockerCommandManager.listContainers();
        return containers.stream()
                .filter(name -> name.startsWith("auto-gpt"))
                .collect(Collectors.toList());
    }
}

