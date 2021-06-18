package gmibank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class State {
    private int id;
    private String name;

    public State(String name) {
        this.name = name;
    }
}
