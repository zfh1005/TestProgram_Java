/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.Mydas;

import jdk.nashorn.internal.runtime.Logging;

/**
 *
 * @author zfh1005
 */
public class Mydas {
    
    public Mydas(){
        this.ProductName = null;
        this.ProductStation = null;
        this.ProductTestData = null;
        this.ProgramVersion = null;
        this.PtsIp = null;
        this.PtsPort = 0;
        this.bConnectFlag = false;        
    }

    public boolean isbConnectFlag() {
        return bConnectFlag;
    }

    public void setbConnectFlag(boolean bConnectFlag) {
        this.bConnectFlag = bConnectFlag;
    }
    
    /*    
    init pts connect with default ip and port
    @return true:connect ok    
    */
    public boolean ConnectPts(){
        String ip = "10.117.34.106";
        int port = 12356;
        if(!isbConnectFlag()){
            if(ConnectPts(ip, port)){
                setbConnectFlag(true);
                return true;
            }
            else{
                Logging.getLogger("connect PTS server failed.");
            }
        }
        return false;
    }
   
    /*    
    init pts connect with default port
    @param ip PTS server ip address
    @return true:connect ok    
    */
    public boolean ConnectPts(String ip){
        int port = 12356;
        if(!isbConnectFlag()){
            if(ConnectPts(ip, port)){
                setbConnectFlag(true);
                return true;
            }
            else{
                Logging.getLogger("connect PTS server failed.");
            }
        }
        return false;
    }
    
    /*    
    init pts connect with setting ip and port
    @param ip PTS server ip address
    @param ptsPort PTS server socket port
    @return true:connect ok    
    */
    public boolean ConnectPts(String ip, int ptsPort){
        // TODO add your handling code here:
        //new a socket
        
        //make connect
       
        return false;
    }
    
    /*
    send data to PTS server socket
    @param data the data sent to PTS server 
    */
   public boolean SendDataToPts(String data){
       //send data to PTS socket
        return false;
    } 

    public void setPtsIp(String PtsIp) {
        this.PtsIp = PtsIp;
    }

    public void setPtsPort(int PtsPort) {
        this.PtsPort = PtsPort;
    }

    public void setProgramVersion(String ProgramVersion) {
        this.ProgramVersion = ProgramVersion;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public void setProductStation(String ProductStation) {
        this.ProductStation = ProductStation;
    }

    public void setProductTestData(String ProductTestData) {
        this.ProductTestData = ProductTestData;
    }
   
   private String PtsIp;
   private int PtsPort;
   private String ProgramVersion;
   private String ProductName;
   private String ProductStation;
   private String ProductTestData;
   private boolean bConnectFlag;
}
