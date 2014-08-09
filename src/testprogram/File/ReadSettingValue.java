/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.File;


import java.util.HashMap;


/**
 *
 * @author zfh1005
 */
public class ReadSettingValue {

    public String getStationName() {
        //open file        
        //read data        
        //paser key word
        return StationName;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getDutVersion() {
        return DutVersion;
    }

    public String getDutBoardID() {
        return DutBoardID;
    }

    public String getDutVersionTime() {
        return DutVersionTime;
    }

    public String getDutBootcode() {
        return DutBootcode;
    }

    public String getDutRegionCode() {
        return DutRegionCode;
    }

    public String[] getDutStringTableCheckSum() {
        return DutStringTableCheckSum;
    }

    public HashMap<String, String> getSettingMap() {
        return SettingMap;
    }

  
    //common data
    public String StationName;
    public String ProductName;
    
    //DUT Info
    public String DutVersion;
    public String DutBoardID;
    public String DutVersionTime;
    public String DutBootcode;
    public String DutRegionCode;
    public String[] DutStringTableCheckSum;
    

    public HashMap<String, String> SettingMap;
  
    
}
