package tf.zod.autoagpt.plugins;

import lombok.extern.slf4j.Slf4j;
import tf.zod.autoagpt.DockerCommandManager;
import tf.zod.autoagpt.model.Plugin;

@Slf4j
public class PluginInstaller {

    private DockerCommandManager dockerCommandManager;

    public PluginInstaller() {
        this.dockerCommandManager = new DockerCommandManager();
    }

    public void installPlugin(Plugin plugin) {
        String command = "git clone " + plugin.getRepo();
        dockerCommandManager.executeCommand(command);
    }
}
