/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram.FileOperation;


/**
 *
 * @author zfh1005
 */
public class FileOperation {
    
    public FileOperation(){
        //common data
        StationName = null;
        ProductName = null;

        //dut info
        DutVersion = null;
        DutBoardID = null;
        DutVersionTime = null;
        DutBootcode = null;
        DutRegionCode = null;
        DUTIpAddress = null;
        
        DutStringTableNumber = 0;
        DutStringTableCheckSum = null;
        
        

        rsv = new ReadSettingValue();
    }
    
    public void getItemsData(){
        //common info
        StationName = rsv.parseSettingValue(SettingFileName, "StationName");
        ProductName = rsv.parseSettingValue(SettingFileName, "ProductName");
        
        //dut info
        DutVersion = rsv.parseSettingValue(SettingFileName, ProductName, "Version");
        DutBoardID = rsv.parseSettingValue(SettingFileName, ProductName, "BoardID");
        DutVersionTime = rsv.parseSettingValue(SettingFileName, ProductName, "VersionTime");
        DutBootcode = rsv.parseSettingValue(SettingFileName, ProductName, "Bootcode");
        DutRegionCode = rsv.parseSettingValue(SettingFileName, ProductName, "RegionCode");
        DUTIpAddress = rsv.parseSettingValue(SettingFileName, ProductName, "DutIp");
        DutStringTableNumber = Integer.parseInt(rsv.parseSettingValue(SettingFileName, ProductName, "StringTableNumber"));
        DutStringTableCheckSum = getCheckSum();
       
        
    }
    
    public String[] getCheckSum(){
        String[] result = null;
        for(int i = 1; i <= DutStringTableNumber; i++){
            String temp = "CheckSum_" + i;
            result[i-1] = rsv.parseSettingValue(SettingFileName, ProductName, temp);
        }
        return result;
    }
    
    //DUT Info
    public String getStationName() {
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
    
     public String getDUTIpAddress() {
        return DUTIpAddress;
    }

   
    
    
    //common data
    private String StationName;
    private String ProductName;
    
    //dut info
    private String DutVersion;
    private String DutBoardID;
    private String DutVersionTime;
    private String DutBootcode;
    private String DutRegionCode;
    
    private int DutStringTableNumber;
    private String[] DutStringTableCheckSum;
    
    private String DUTIpAddress;

    private ReadSettingValue rsv;
    
    private final String SettingFileName = "c:\\TestInfomation.ini";
    
}
