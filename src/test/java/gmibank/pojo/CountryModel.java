package gmibank.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountryModel {
    long id;
    String name;

    public CountryModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "{ " +"id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
