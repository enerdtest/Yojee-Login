package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath="configs/config.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
               properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }
    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
    }
    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }
    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }
    public String getUserName() {
        String userName = properties.getProperty("userName");
        if(userName != null ) return userName;
        else throw new RuntimeException("userName not specified in the Configuration.properties file.");
    }
    public String getPassword() {
        String passWord = properties.getProperty("passWord");
        if(passWord != null) return passWord;
        else throw new RuntimeException("passWord not specified in the Configuration.properties file.");
    }
    public String getHomePageTitle() {
        String homePageTitle = properties.getProperty("homePageTitle");
        if(homePageTitle != null) return homePageTitle;
        else throw new RuntimeException("homePageTitle not specified in the Configuration.properties file.");
    }
    public String getUserProfileName(){
        String userProfileName = properties.getProperty("userProfileName");
        if(userProfileName != null) return userProfileName;
        else throw new RuntimeException("userProfileName not specified in the Configuration.properties file.");
    }
    public String getWorkName(){
        String workerName = properties.getProperty("workerName");
        if(workerName != null) return workerName;
        else throw new RuntimeException("workerName not specified in the Configuration.properties file.");
    }
    public String getWorkPhoneNumber(){
        String workPhoneNumber = properties.getProperty("workPhoneNumber");
        if(workPhoneNumber != null) return workPhoneNumber;
        else throw new RuntimeException("WorkPhoneNumber not specified in the Configuration.properties file.");
    }
    public String getWorkEmail(){
        String workerEmail = properties.getProperty("workerEmail");
        if(workerEmail != null) return workerEmail;
        else throw new RuntimeException("workerEmail not specified in the Configuration.properties file.");
    }
    public String getSMSToken(){
        String SMSToken = properties.getProperty("SMSToken");
        if(SMSToken != null) return SMSToken;
        else throw new RuntimeException("SMSToken not specified in the Configuration.properties file.");
    }

}
