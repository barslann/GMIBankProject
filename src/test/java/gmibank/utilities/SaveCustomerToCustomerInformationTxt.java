package gmibank.utilities;

import gmibank.pojo.CustomerInformation;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveCustomerToCustomerInformationTxt {
    private static final String filepath="/Users/coderman/Desktop/GMIBankFramework/src/test/resources/data/CustomerInformation.txt";

//    public static void main(String[] args) {
//        CustomerInformation customerInformation = new CustomerInformation("123-12-1241","Esra","sdljf","123 5th aven","123-456-7890","test1","test1@gmail.com","Asdf1234?");
//        CustomerInformation customerInformation1 = new CustomerInformation("123-12-1241","Bekir","sdljf","123 5th aven","123-456-7890","test1","test1@gmail.com","Asdf1234?");
//        WriteObjectToFile(customerInformation.toString());
//        WriteObjectToFile(customerInformation1.toString());
//    }

    public static void WriteObjectToFile(Object customer) {
        try {
            FileWriter fileWriter = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            String customerInfo = customer.toString();
            bw.append(customerInfo);
            bw.newLine();
            bw.close();
            System.out.println("Customer successfully added to customer information txt file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
