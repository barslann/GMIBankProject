package gmibank.utilities;

import gmibank.pojo.Country;
import gmibank.pojo.Customer;
import gmibank.pojo.CustomerAccount;
import gmibank.pojo.CustomerInformation;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class UtilityMethods {


    public static void saveObjectToFile(String filePath,Object object) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            String customerInfo = object.toString();
            bw.append(customerInfo);
            bw.newLine();
            bw.close();
            System.out.println("Object successfully added to txt file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveObjectToFile(String filePath, Customer[] customers) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for(Customer customer: customers) {
                bw.append(customer.getFirstName() + "," + customer.getLastName()+ "," + customer.getSsn());


                bw.newLine();
            }
            bw.close();
            System.out.println("Customers successfully added to txt file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void saveCountriesToFile(String filePath, Country[] countries) {
        try {
            Set<String> countrySet = new HashSet<>();
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for(Country country: countries) {
                if(countrySet.add(country.getName())){
                    bw.append(country.getId() + "," + country.getName()+ "," + country.getState());
                    bw.newLine();
                }
            }
            bw.close();
            System.out.println("Countries successfully added to txt file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<String> getCustomerSsnList() {
        List<String> customerList = new ArrayList<>();
        String sCurrentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader("/Users/coderman/Desktop/GMIBankFramework/src/test/resources/data/CustomerData.txt"));
            while (true) {
                sCurrentLine = br.readLine();
                if (sCurrentLine == null) break;
                else{
                    customerList.add(sCurrentLine.split(",")[2]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return customerList;
    }


    public static CustomerInformation getCustomerFromCustomerInformationFile() {
        String lastLine = "";
        String sCurrentLine;
        try {
            BufferedReader br = new BufferedReader(new FileReader(ConstantVariables.customerInformationFilePath));
            while (true) {
                sCurrentLine = br.readLine();
                if (sCurrentLine == null) break;
                else{
                    lastLine = sCurrentLine;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        String[] values =lastLine.split(",");
        CustomerInformation customer = new CustomerInformation(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7]);

        return customer;
    }

    public static String[] getCustomerAccountFromCustomerAccountFile(String customerName) {
        String sCurrentLine;
        List<String> customerAccounts = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ConstantVariables.customerAccountFilePath));
            while (true) {
                sCurrentLine = br.readLine();
                if (sCurrentLine == null) break;
                String[] values =sCurrentLine.split(",");
                if(values[0].equals(customerName)){
                    customerAccounts.add(values[1]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        String[] accounts =new String[customerAccounts.size()];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = customerAccounts.get(i);
        }

        return accounts;
    }

    public static int[] parseCurrentTime(){
        Calendar rightNow = Calendar.getInstance();
        rightNow.add(Calendar.MONTH, 1);
        int day = rightNow.get(Calendar.DAY_OF_MONTH);
        int month = rightNow.get(Calendar.MONTH);
        int year = rightNow.get(Calendar.YEAR);
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        int minute = rightNow.get(Calendar.MINUTE);
        int period = rightNow.get(Calendar.AM_PM);//0 -> AM  1->PM
        return new int[]{month,day,year,hour,minute,period};
    }


//    public static String getToken(){
//        Response response = RestAssured.given().queryParam("admin46team");
//    }




}
