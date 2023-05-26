package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Slf4j
public class PluginManager {

    private DockerCommandManager dockerCommandManager;

    public PluginManager() {
        this.dockerCommandManager = new DockerCommandManager();
    }

    public void installPlugins() {
        String json = readJsonFromResource("plugin_src.json");
        JSONArray plugins = new JSONArray(json);

        for (int i = 0; i < plugins.length(); i++) {
            JSONObject plugin = plugins.getJSONObject(i);
            String repo = plugin.getString("repo");
            String command = "git clone " + repo;
            dockerCommandManager.executeCommand(command);
        }
    }

    private String readJsonFromResource(String filename) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            log.error("Error reading JSON file: {}", filename, e);
            return null;
        }
    }
}
