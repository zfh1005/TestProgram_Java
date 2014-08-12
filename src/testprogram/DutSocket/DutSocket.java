/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram.DutSocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import testprogram.FileOperation.FileOperation;

/**
 *
 * @author zfh1005
 */
public class DutSocket {
    //struct function
    public DutSocket(){
        tsc = new TcpSocketClient ();
        MacAddress = "00000000001";
    }
    
    //return Mac to anthor funtion interface
    public String getMacAddress(){
        return MacAddress;
    }
   
     
    //check DUT bootup OK
    public String CheckDutBootUp(FileOperation tfot){
        String result = "UN00";
        boolean bReturnResult = false;
        String DutIpAddress = tfot.getDUTIpAddress();
        
        int iRtyNumber = 0;
        try{ 
            while(true){                
                //ping DUT
                bReturnResult = tsc.PingIpAddress(DutIpAddress, 2, 512, 1);
                if(bReturnResult == true){
                    break;
                }
                iRtyNumber ++;
                if(iRtyNumber >= 4){
                    //show error information
                    result = "IN10";
                    return result;
                }
            }         
            
            //get MAC
            MacAddress = tsc.ArpGetMac(DutIpAddress);
            
            iRtyNumber = 0;                    
            bReturnResult = false;
            while(true){
                //run telnetenable
                tsc.DutSocketTelnetenable(DutIpAddress, MacAddress, DefaultTelnetUserName, DefaultTelnetPassword);   
                //run telnet           
                bReturnResult = tsc.DutSocketConnect(DutIpAddress, TcpSocketDefaultPort);
                if(bReturnResult == true){
                    break;                
                } 
                iRtyNumber ++;
                if(iRtyNumber >= 4){
                    //show error information
                    result = "IN20";
                    return result;
                }
            }            
        }
        catch(IOException e){
            return result;
        }  
        return "PASS";
    }
    
    public boolean SendDutCommand(String Command){
        boolean result = false;
        try {
            result = tsc.SendDutCommand(Command, DefaultSocketReturnValue, DefaultSocketTimeoutTime);            
        } 
        catch (IOException ex) {
            Logger.getLogger(DutSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean SendDutCommand(String Command, String CommandReturn, int timeout){
        boolean result = false;
        try {
            result = tsc.SendDutCommand(Command, CommandReturn, timeout);            
        } 
        catch (IOException ex) {
            Logger.getLogger(DutSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String getRuturnBurrfer(){
        return tsc.DutSocketReturnString;
    }
    
    
    private TcpSocketClient tsc;
    private String MacAddress;
    
    
    private final String DefaultTelnetUserName = "Gearguy";
    private final String DefaultTelnetPassword = "Geardog";
    private final String DefaultSocketReturnValue = "#";
    private final int DefaultSocketTimeoutTime = 15000;
    private final int TcpSocketDefaultPort = 23;
}
