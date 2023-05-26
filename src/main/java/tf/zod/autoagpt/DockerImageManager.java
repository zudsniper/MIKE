package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DockerImageManager {

    private DockerCommandManager dockerCommandManager;

    public DockerImageManager() {
        this.dockerCommandManager = new DockerCommandManager();
    }

    public void saveImage(String imageName, String newImageName) {
        String command = "docker save " + imageName + " > " + newImageName;
        dockerCommandManager.executeCommand(command);
    }

    public void loadImage(String imageName) {
        String command = "docker load < " + imageName;
        dockerCommandManager.executeCommand(command);
    }
}
