/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 控制产品的类,产品作为TCP server socket，测试程序作为TCP client socket,端口号23
 * 包括如下函数：
 * public boolean DutSocketConnect(String IP, int DutPortNo);
 * public boolean DutSocketClose();
 * public boolean SendDutCommand(String szCmd, String szCheckKeyWord, int iTimeOutTime);
 * public boolean ReadDutReturnInfo();
 * public boolean SocketConnectStatue();
 */
package testprogram.DutSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.Logging;
import testprogram.TypeChange;



/**
 
 * @author zfh1005
 */

public class TcpSocketClient { 
    //struct function
    public TcpSocketClient(){
        
    }
   
    //ping IP address
    public boolean PingIpAddress(String Ip, int PingCount, int PacketLength, int PingSuccessCount) {  
        //Ping sample
        //ping 127.0.0.1 -n 2 -l 21
        bPingOkFlag = false;
        BufferedReader br = null;
        try {
            String Cmd ;
            
            Cmd = ((("ping " + Ip) + " -n " + PingCount) + " -l " + PacketLength);
            Process p = Runtime.getRuntime().exec(Cmd);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            String PingOkString = new String();
            while((line = br.readLine()) != null){
                line.concat("\n");
                sb.append(line);
                if(line.contains("%")){
                    //Sample
                    //Packets: Sent = 2, Received = 2, Lost = 0 (0% loss),
                    PingOkString = line;
                    break;
                }
            } 
            //Sample
            //Packets: Sent = 2, Received = 2, Lost = 0 (0% loss),
            String sResult = (((PingOkString.split(","))[1]).split("="))[1];
            int iResult = TypeChange.StringToInt(sResult);
            if(iResult >= PingSuccessCount){
                bPingOkFlag = true;
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(TcpSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return bPingOkFlag;
    }
    
    //arp -a get MAC
    public String ArpGetMac(String InterFaceIp) {
        String ReturnResult = "";
        bArpGetMacOkFlag = false;
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec("arp -a");
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            String ArpInterString = new String();
            while((line = br.readLine()) != null){
                line.concat("\n");
                sb.append(line);
                if(line.contains(" " + InterFaceIp + " ")){
                    /*Sample
                    Interface: 10.116.24.101 on Interface 0x2
                    Internet Address      Physical Address      Type
                    10.116.24.1           00-1d-a2-af-5c-d3     dynamic
                     * 
                     */
                    ArpInterString = line;
                    break;
                }
            }
            String[] sTempBuffer = ArpInterString.split(" ");
            int i = 0;
            String sMacResult = "";
            while(true){
                if(i >= sTempBuffer.length){
                    break;
                }
                else{
                    if(sTempBuffer[i].contains("-")){
                        sMacResult = sTempBuffer[i];
                    }
                }
                i++;                
            }            
            ReturnResult = (sMacResult.replaceAll("-", "")).toUpperCase();    
            if(ReturnResult.length() == 12){
                bArpGetMacOkFlag = true;                
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(TcpSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ReturnResult;  
    }
    
    //run telnetenable 
    public void DutSocketTelnetenable(String IP, String MAC, String Username, String Password){ 
       
        String szCMD = new StringBuilder("telnetenable".length() + " ".length() + IP.length() + " ".length() + MAC.length() + " ".length() + Username.length() + " ".length() + Password.length())
                .append("telnetenable").append(" ").append(IP.trim()).append(" ").append(MAC.trim().toUpperCase()).append(" ").append(Username.trim()).append(" ").append(Password.trim())
                .toString();           
        try {
            Runtime.getRuntime().exec(szCMD);
        } 
        catch (IOException ex) {
            Logger.getLogger(TcpSocketClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //run telnet
    //通过IP,端口号连接socket
    public boolean DutSocketConnect(String IP, int PortNo) throws IOException{        
        InetAddress addr = InetAddress.getByAddress(IP.getBytes()); 
        bSocketConnectFlag = false;
        DutSocketClient = new Socket(addr, PortNo);
        
        if(DutSocketReturnString.contains("Busybox"))
        {           
            //System.out.println("connect server socket");            
            bSocketConnectFlag = true;
        }
        return bSocketConnectFlag;
    }  
    
    //关闭socket
    public boolean DutSocketClose() throws IOException{
        DutSocketClient.close();        
        return true;        
    }
    
    //向server socket发送命令
    private boolean SendDutCommand(String szCmd) throws IOException{             
        PrintWriter out;
        out = new PrintWriter(new BufferedWriter(
        new OutputStreamWriter(DutSocketClient.getOutputStream())), true);
        out.println(szCmd);
        return true;
     }   
    
    //向server socket发送命令并在单位时间内等待回传
    public boolean SendDutCommand(String szCmd, String szCheckKeyWord, int iTimeOutTime)throws IOException{  
        try{
            DutSocketReturnString = "";
            if(DutSocketClient.isConnected())
            {
                SendDutCommand(szCmd);
            }
            int iRtyNum = iTimeOutTime / 100;
            for(int iTime = iRtyNum; iTime >= 0; iTime--){
                DutSocketClient.wait(100);
                if(szCheckKeyWord == null){
                    return true;
                }                  
                else{
                    if(DutSocketReturnString.contains(" " + szCheckKeyWord + " ")){
                        return true; 
                    }
                }
            }        
            return false;       
        }
        catch(InterruptedException e){
            Logging.getLogger(e.toString());
            return false;
        }
    }
    
    //接收server socket的资料
    public boolean ReadDutReturnInfo() throws IOException{     
        BufferedReader in = new BufferedReader(new InputStreamReader(DutSocketClient.getInputStream())); 
        while (true) {  
            String msg = in.readLine();  
            DutSocketReturnString += msg;            
            if ( (DutSocketClient.isInputShutdown()) || (DutSocketClient.isOutputShutdown()) ) {  
                break;  
            }
            if(0 == iShowDebugInfo){
                System.out.println(in);
            }           
        }
        return true;
    }
    
    public boolean SocketConnectStatue() throws SocketException{
        return DutSocketClient.getKeepAlive();       
    }
    
    public static void main(String[] args){
        TcpSocketClient DutSocket = new TcpSocketClient();
        boolean bReturnResult = false;
        int iRtyNumber = 0;
        try{ 
            while(true){                
                //ping DUT
                bReturnResult = DutSocket.PingIpAddress("12.0.0.1", 2, 512, 1);
                if(bReturnResult == true){
                    break;
                }
                iRtyNumber ++;
                if(iRtyNumber >= 4){
                    //show error information
                    return;
                }
            }         
            
            //get MAC
            MacAddress = DutSocket.ArpGetMac("10.116.24.1");
            
            iRtyNumber = 0;                    
            bReturnResult = false;
            while(true){
                //run telnetenable
                DutSocket.DutSocketTelnetenable("192.168.1.1", MacAddress, "Gearguy", "Geardog");   
                //run telnet           
                bReturnResult = DutSocket.DutSocketConnect("192.168.1.1", 23);
                if(bReturnResult == true){
                    break;                
                } 
                iRtyNumber ++;
                if(iRtyNumber >= 4){
                    //show error information
                    return;
                }
            }            
        }
        catch(IOException e){
            return;
        }    
    } 
    
    //是否输出debug信息
    //1:enable  ; 0:not disable
    public static int iShowDebugInfo ;  
    //Dut socket return inforation
    public String DutSocketReturnString ;
    //mark DUT socket connect status
    public static boolean bSocketConnectFlag ;
    //mark ping status
    public static boolean bPingOkFlag ;
    //mark get mac status flag
    public static boolean bArpGetMacOkFlag;
    //recode MAC
    public static String MacAddress;
    
    private Socket DutSocketClient;
}
