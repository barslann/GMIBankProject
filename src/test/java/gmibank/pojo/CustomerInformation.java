package gmibank.pojo;


import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerInformation implements Serializable {
    private String ssn;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String userName;
    private String email;
    private String password;

    @Override
    public String toString() {
        return ssn + ','+
                        firstName + ',' +
                        lastName + ',' +
                        address + ',' +
                        phoneNumber + ',' +
                        userName + ',' +
                        email + ',' +
                        password;
    }
}
