package tf.zod.autoagpt.model;

import lombok.Data;

@Data
public class Plugin {
    private String name;
    private String version;
    private String repo;
}
