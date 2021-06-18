package gmibank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    private int id;
    private String name;
    private State state;

    @Override
    public String toString() {
        return id + "," + name+ ","+ state;
    }
}