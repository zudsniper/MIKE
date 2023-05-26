package tf.zod.autoagpt.model;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class PluginList {

    public List<Plugin> loadPlugins() {
        String json = readJsonFromResource();
        JSONArray pluginsJson = new JSONArray(Objects.requireNonNull(json));

        List<Plugin> plugins = new ArrayList<>();
        for (int i = 0; i < pluginsJson.length(); i++) {
            JSONObject pluginJson = pluginsJson.getJSONObject(i);
            Plugin plugin = new Plugin();
            plugin.setName(pluginJson.getString("name"));
            plugin.setVersion(pluginJson.getString("version"));
            plugin.setRepo(pluginJson.getString("repo"));
            plugins.add(plugin);
        }

        return plugins;
    }

    private String readJsonFromResource() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("plugin_src.json");
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + "plugin_src.json");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (Exception e) {
            log.error("Error reading JSON file: {}", "plugin_src.json", e);
            return null;
        }
    }
}
