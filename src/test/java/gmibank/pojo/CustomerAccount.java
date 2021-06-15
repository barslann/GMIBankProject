package gmibank.pojo;

import io.cucumber.java.mk_latn.No;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccount {
    private String customerName;
    private String description;
    private String balance;
    private String accountType;
    private String createdDate;

    @Override
    public String toString() {
        return
                customerName + ',' +
                        description + ',' +
                        balance + ',' +
                        accountType + ',' +
                        createdDate;
    }
}
