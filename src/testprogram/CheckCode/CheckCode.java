/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.CheckCode;

/**
 *
 * @author zfh1005
 * 
 */
public class CheckCode {
    
    /*
    check dut FW version
    @param versionSpec Spec the dut version spec,come from setting dut file
    @return true:the version from dut the same with setting file
    */
    public boolean CheckVersion(String versionSpec){
        //send check command to DUT socket
        
        //compare dut respone buffer with parameter
        
        return false;
    }
    
    /*
    check dut FW version time
    @param versionTimeSpec Spec the dut version time spec,come from setting dut file
    @return true:the version time from dut the same with setting file
    */
    public boolean CheckVersionTime(String versionTimeSpec){
        return false;
    }
    
    /*
    check dut Bootcode version
    @param bootcodeSpec Spec the dut Bootcode spec,come from setting dut file
    @return true:the Bootcode version from dut the same with setting file
    */
    public boolean CheckBootcode(String bootcodeSpec){
        return false;
    }
    
    /*
    check dut mac information
    @param macSpec the mac from sfis system
    @return true:the MAC information from dut the same with SFIS system
    */
    public boolean CheckMac(String macSpec){
        return false;
    }
    
     /*
    check dut pin information
    @param pinSpec the pin from sfis system
    @return true:the PinCode information from dut the same with SFIS system
    */
    public boolean CheckPin(String pinSpec){
        return false;
    }
    
     /*
    check dut ssn information
    @param ssnSpec the ssn from sfis system
    @return true:the SSN information from dut the same with SFIS system
    */
    public boolean CheckSsn(String ssnSpec){
        return false;
    }
    
     /*
    check dut ssid information
    @param ssidSpec the mac from sfis system
    @return true:the SSID information from dut the same with SFIS system
    */
    public boolean CheckSSID(String ssidSpec){
        return false;
    }
    
     /*
    check dut passphrase information
    @param passphraseSpec the mac from sfis system
    @return true:the passphraseSpec information from dut the same with SFIS system
    */
    public boolean CheckPassphrase(String passphraseSpec){
        return false;
    }
    
     /*
    check dut regioncode information
    @param regioncodeSpec the mac from sfis system
    @return true:the RegionCode information from dut the same with SFIS system
    */
    public boolean CheckRegionCode(String regioncodeSpec){
        return false;
    }
    
     /*
    check dut checksum information
    @param checksumSpec the mac from sfis system
    @return true:the StringTableCheckSum information from dut the same with SFIS system
    */
    public boolean CheckStringTableCheckSum(String[] checksumSpec){
        return false;
    }
    
}
