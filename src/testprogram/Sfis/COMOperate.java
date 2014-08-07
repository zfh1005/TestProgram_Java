/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.Sfis;

import gnu.io.*;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cq
 */
public class COMOperate implements SerialPortEventListener {   
    static CommPortIdentifier CommPortID;//检测系统可用的通讯端口类
    static Enumeration CommPortList; //Enumeration 在java.util中
    InputStream inputStream;
    OutputStream outputStream;
    SerialPort CommSerialPort;
    Thread CommReadThread;
    String ComReadBuffer;
   
    public boolean COMOperateOpen(String COM_Name){ 
        CommPortList = CommPortIdentifier.getPortIdentifiers();
        while(CommPortList.hasMoreElements()){
            CommPortID =  (CommPortIdentifier) CommPortList.nextElement();
            if(CommPortID.getPortType() == CommPortIdentifier.PORT_SERIAL){
                if(CommPortID.getName().equals(COM_Name)){
                    try{
                        //设置串口参数
                        try {                            
                            CommSerialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                        } 
                        catch (UnsupportedCommOperationException ex) {
                            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        //open com port
                        CommSerialPort = (SerialPort)CommPortID.open(COM_Name, 2000);  
                        
                        //seeting OutputStream
                        this.COMOperateSetInputStream();
                        
                        //setting InputStream
                        this.COMOperateSetOutputStream();
                                
                        //设置监听器
                        try{
                            CommSerialPort.addEventListener(this); 
                        }
                        catch(TooManyListenersException e){            
                        }
                        //侦测到串口数据,触发事件
                        CommSerialPort.notifyOnDataAvailable(true);
                        return true;
                    }
                    catch(PortInUseException e){
                        System.out.println("Open COM port failed!");
                    }
                }
            }        
        }        
        return false;
    }
    public void COMOperateSetInputStream(){ 
        try {
            inputStream = CommSerialPort.getInputStream();
        } 
        catch (IOException ex) {
            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    public void COMOperateSetOutputStream(){ 
        try {
            outputStream = CommSerialPort.getOutputStream();
        } 
        catch (IOException ex) {
            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public void COMOperateRead(){  
        this.COMOperateReadThread();        
        return ;
    }
    
    public void COMOperateReadThread(){ 
        CommReadThread = new Thread();
        CommReadThread.start();
    }
    
    public void run() { 
        /*Read mode*/                    
        byte[] readBuffer = new byte[1024];
        try {
            while(inputStream.available() > 0){
                int numBytes = inputStream.read(readBuffer);
                if(numBytes > 0){
                    ComReadBuffer = new String(readBuffer);
                }                
                try {
                    CommReadThread.sleep(100);
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
                }               
            }
        } 
        catch (IOException ex) {
            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }    
    
    @Override
    public void serialEvent(SerialPortEvent event){
        try {
            CommSerialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE); 
        } 
        catch (UnsupportedCommOperationException ex) {
            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
   public void COMOperateWrite(String Write_Data){ 
        byte WriteData[] = Write_Data.getBytes();
        try {
            outputStream.write(WriteData);
        } 
        catch (IOException ex) {
            Logger.getLogger(COMOperate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ;
    }
    
    public void COMOperateClose(String COM_Name){ 
        this.CommSerialPort.close();
        return ;
    }
    
}
