package tf.zod.autoagpt.plugins;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Slf4j
public class PluginManager {

    public void installPlugins() {
        // Read the plugin_src.json file
        String json = readJsonFromResource("/plugin_src.json");
        if (json == null) {
            System.err.println("Failed to read plugin_src.json");
            return;
        }

        // Parse the JSON and install each plugin
        JSONArray plugins = new JSONArray(json);
        for (int i = 0; i < plugins.length(); i++) {
            JSONObject plugin = plugins.getJSONObject(i);
            String name = plugin.getString("name");
            String url = plugin.getString("url");

            // TODO: Download and install the plugin from the URL
            System.out.println("Installing plugin: " + name + " from " + url);
        }
    }

    public String readJsonFromResource(String resourcePath) {
        try (InputStream is = getClass().getResourceAsStream(resourcePath)) {
            if (is == null) {
                return null;
            }
            return IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
