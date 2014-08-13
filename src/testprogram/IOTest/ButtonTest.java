/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.IOTest;

import java.lang.Thread;
import javax.swing.JOptionPane;
import testprogram.DutSocket.DutSocket;

/**
 *
 * @author zfh1005
 */
public class ButtonTest {
    
    public ButtonTest(DutSocket socket) {
        dutSocket = socket;
        //send command to dut socket
        for(int i = 0; i < commonButtonTestCommand.length; i++){
            socket.SendDutCommand(commonButtonTestCommand[i]);
        }
        
        //read dut buffer thread
        
        
        //show messagebox tell operation press button
        
        //if press right button auto close messagebox
        
    }
    
    private boolean WpsButtonTest(){
        boolean result = false;
        buttonTestThread btt = new buttonTestThread(dutSocket, "wps");
        btt.start();
        //show dialog
        
        JOptionPane.showInternalConfirmDialog(null, wpsButtonInfo[1], wpsButtonInfo[0], JOptionPane.INFORMATION_MESSAGE); 
        if(btt.getResult() == true){
            result = true;
        }
        return result;
    }
    
    private boolean WifiButtonTest(){
        boolean result = false;
        buttonTestThread btt = new buttonTestThread(dutSocket, "wifi");
        btt.start();
        if(btt.getResult() == true){
            result = true;
        }
        return result;
    }
    
    private boolean ResetButtonTest(){
        boolean result = false;
        buttonTestThread btt = new buttonTestThread(dutSocket, "reset");
        btt.start();
        if(btt.getResult() == true){
            result = true;
        }
        return result;
    }
    
    
    //inner class to read socket buffer
    private class buttonTestThread extends Thread{
        public buttonTestThread(DutSocket socket, String name){
            buffer = socket.getRuturnBurrfer();
            buttonName = name;
        }        
        @Override
        public void run() {
            result = false;
            if(buttonName.toUpperCase().contains("RESET")){
                if(buffer.contains(resetButtonInfo[2])){
                    result = true;
                }
            }
            if(buttonName.toUpperCase().contains("WPS")){
                if(buffer.contains(wpsButtonInfo[2])){
                    result = true;
                }
            }
            if(buttonName.toUpperCase().contains("WIFI")){
                if(buffer.contains(wifiButtonInfo[2])){
                    result = true;
                }
            }
            result = false;
        } 
        
        public boolean getResult(){
            return result;
        }
        
        private final String buffer;
        private final String buttonName;
        private boolean result ;
    }
    
    private final String[] commonButtonTestCommand = {
        "reset_no_reboot",
        "nvram set TE_TEST=1",
        "killall swresetd",
        "swresetd"
    };
    
    private final String[] resetButtonInfo ={
        "請按一下Reset按鈕,持續一秒鐘!!!",//notices message
        "Reset Button Check",//notices message box name
        "reset button is pressed"//button press return value
    };
    
    private final String[] wpsButtonInfo ={
        "請按一下WPS按鈕,持續一秒鐘!!!",
        "WPS Button Check",
        "wps button is pressed"
    };
    
    private final String[] wifiButtonInfo ={
        "請按一下Wifi按鈕,持續一秒鐘!!!",
        "Wifi Button Check",
        "wifi button is pressed"
    };
    
    private final DutSocket dutSocket;
}
