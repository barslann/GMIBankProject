package gmibank.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Registration {
    int id;
    String snn;
    String firstName;
    String lastName;
    String address;
    String mobilePhoneNumber;
    int userId;
    String userName;
    String email;
    String createDate;
    @Override
    public String toString() {
        return
                id + "," + snn + "," +
                        firstName + "," +
                        lastName + "," +
                        address + "," +
                        mobilePhoneNumber + "," +
                        userId + ","+ userName + "," + email + "," + createDate + "\n";
    }
}