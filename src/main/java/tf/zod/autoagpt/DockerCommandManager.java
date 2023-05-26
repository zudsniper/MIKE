package tf.zod.autoagpt;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class DockerCommandManager {

    public String executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                log.info(line);
            }

            int exitCode = process.waitFor();
            log.info("Exit code: {}", exitCode);
        } catch (Exception e) {
            log.error("Error executing command: {}", command, e);
        }
        return command;
    }

    public List<String> listContainers() {
        String command = "docker ps -a --format '{{.Names}}'";
        String output = executeCommand(command);
        return Arrays.asList(output.split("\n"));
    }

}
