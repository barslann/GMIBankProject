package gmibank.utilities;

import gmibank.pojo.Country;
import gmibank.pojo.Customer;
import gmibank.pojo.CustomerInformation;
import gmibank.pojo.Registration;


import java.io.*;
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
    public static void saveCountriesToFile(String filePath, Object[] objects) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for(Object object: objects) {
                    bw.append(object.toString());
                    bw.newLine();
            }
            bw.close();
            System.out.println("Countries successfully added to txt file");

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
    public static String parseToken(String token){
        String resultToken = token.split("\"")[3];
        ConstantVariables.generalToken = resultToken;
        return resultToken;
    }
    public static List<String> returnAllStatesIdList (String filePath) {
        List<String> all = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            while (line != null) {
                // all.add(Integer.parseInt(line.split(",")[0]));
                all.add(line.split(",")[0]);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return all;
    }
    public static List<Integer> returnAllCountryIdList (String filePath) {
        List<Integer> all = new ArrayList<Integer>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            while (line != null) {
                all.add(Integer.parseInt(line.split(",")[0]));
                //all.add(line.split(",")[1]);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return all;
    }
    public static Map<Integer,String>  saveDataInfileAllRegistrationInfo(String fileName, Registration[] registration) {
        Map<Integer,String> map= new HashMap<>();
        try {
            FileWriter fileWriter = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int i = 0; i < registration.length; i++) {
                map.put(registration[i].getId(), registration[i].getUserName());
                bw.append(registration[i].getId() + "," + registration[i].getSnn()+"," + registration[i].getUserName() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
