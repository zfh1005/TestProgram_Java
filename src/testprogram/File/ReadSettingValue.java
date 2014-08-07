/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.File;


import java.util.HashMap;


/**
 *
 * @author cq
 */
public class ReadSettingValue {

    public String getDutBoardID() {
        return DutBoardID;
    }

    public void setDutBoardID(String DutBoardID) {
        this.DutBoardID = DutBoardID;
    }

    public String getDutBootcode() {
        return DutBootcode;
    }

    public void setDutBootcode(String DutBootcode) {
        this.DutBootcode = DutBootcode;
    }

    public String getDutRegionCode() {
        return DutRegionCode;
    }

    public void setDutRegionCode(String DutRegionCode) {
        this.DutRegionCode = DutRegionCode;
    }

    public String[] getDutStringTableCheckSum() {
        return DutStringTableCheckSum;
    }

    public void setDutStringTableCheckSum(String[] DutStringTableCheckSum) {
        this.DutStringTableCheckSum = DutStringTableCheckSum;
    }

    public String getDutVersion() {
        return DutVersion;
    }

    public void setDutVersion(String DutVersion) {
        this.DutVersion = DutVersion;
    }

    public String getDutVersionTime() {
        return DutVersionTime;
    }

    public void setDutVersionTime(String DutVersionTime) {
        this.DutVersionTime = DutVersionTime;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String StationName) {
        this.StationName = StationName;
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
