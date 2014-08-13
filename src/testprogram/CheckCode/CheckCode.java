/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.CheckCode;

import testprogram.DutSocket.DutSocket;

/**
 *
 * @author zfh1005
 * 
 */
public class CheckCode {
    public CheckCode(DutSocket Socket){
        ccf = new CheckCodeFormat();
        dutSocket = Socket;
    }
    
    /*
    check dut FW version
    @param versionSpec Spec the dut version spec,come from setting dut file
    @return true:the version from dut the same with setting file
    */
    public boolean CheckVersion(String versionSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckVersion);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(versionSpec)){
            return true;
        }
        return false;
    }
    
    /*
    check dut FW version time
    @param versionTimeSpec Spec the dut version time spec,come from setting dut file
    @return true:the version time from dut the same with setting file
    */
    public boolean CheckVersionTime(String versionTimeSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckVersionTime);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(versionTimeSpec)){
            return true;
        }
        return false;
    }
    
    /*
    check dut Bootcode version
    @param bootcodeSpec Spec the dut Bootcode spec,come from setting dut file
    @return true:the Bootcode version from dut the same with setting file
    */
    public boolean CheckBootcode(String bootcodeSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckBootcodeVersion);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(bootcodeSpec)){
            return true;
        }
        return false;
    }
    
    /*
    check dut mac information
    @param macSpec the mac from sfis system
    @return true:the MAC information from dut the same with SFIS system
    */
    public boolean CheckMac(String macSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckMac);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(macSpec)){
            return true;
        }
        return false;
    }
    
     /*
    check dut pin information
    @param pinSpec the pin from sfis system
    @return true:the PinCode information from dut the same with SFIS system
    */
    public boolean CheckPin(String pinSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckPincode);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(pinSpec)){
            return true;
        }
        return false;
    }
    
     /*
    check dut ssn information
    @param ssnSpec the ssn from sfis system
    @return true:the SSN information from dut the same with SFIS system
    */
    public boolean CheckSsn(String ssnSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckSsn);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(ssnSpec)){
            return true;
        }
        return false;
    }
    
     /*
    check dut ssid information
    @param ssidSpec the mac from sfis system
    @return true:the SSID information from dut the same with SFIS system
    */
    public boolean CheckSSID(String ssidSpec){
        //check ssid foramt
        if(ccf.checkSsidFormat(ssidSpec) == false){
            return false;
        }
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckSsid);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(ssidSpec)){
            return true;
        }
        return false;
    }
    
     /*
    check dut passphrase information
    @param passphraseSpec the mac from sfis system
    @return true:the passphraseSpec information from dut the same with SFIS system
    */
    public boolean CheckPassphrase(String passphraseSpec){
        //check passphrase format
        if(ccf.checkPasspharseFormat(passphraseSpec) == false){
            return false;
        }
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckPaseroharse);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(passphraseSpec)){
            return true;
        }
        return false;
    }
    
     /*
    check dut regioncode information
    @param regioncodeSpec the mac from sfis system
    @return true:the RegionCode information from dut the same with SFIS system
    */
    public boolean CheckRegionCode(String regioncodeSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CommandCheckRegionCode);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(regioncodeSpec)){
            return true;
        }
        return false;
    }
    
    public boolean CheckCodeCommon(String CheckCommand, String CheckCommandSpec){
        //send check command to DUT socket
        dutSocket.SendDutCommand(CheckCommand);
        //compare dut respone buffer with parameter
        if(dutSocket.getRuturnBurrfer().contains(CheckCommandSpec)){
            return true;
        }
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
    
    private DutSocket dutSocket;
    private CheckCodeFormat ccf;
    
    private final String CommandCheckVersion = "version";
    private final String CommandCheckVersionTime = "version";
    private final String CommandCheckBootcodeVersion = "version";
    private final String CommandCheckMac = "burnethermac";
    private final String CommandCheckPincode = "burnpin";
    private final String CommandCheckSsn = "burnsn";
    private final String CommandCheckSsid = "burnssid";
    private final String CommandCheckPaseroharse = "burnpass";
    private final String CommandCheckRegionCode = "burnsku";
    
}
