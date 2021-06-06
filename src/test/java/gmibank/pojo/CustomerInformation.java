package gmibank.pojo;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerInformation {
    private String ssn;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String userName;
    private String email;
    private String password;

}
