package io.github.anxolerd.firebasetutorial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor
@AllArgsConstructor
public class Task {
    public static final String COLLECTION_NAME = "tasks";

    @Getter private String id;
    @Getter private String name;
    @Getter private String description;
    @Getter private Boolean done;

}
