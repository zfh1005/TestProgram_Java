/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram.IOTest;

import testprogram.DutSocket.DutSocket;


/**
 *
 * @author zfh1005
 */
public class IOTest {
    //struct function
    public IOTest(DutSocket dutSocket){
        bt = new ButtonTest(dutSocket);
        lt = new LEDTest(dutSocket);
        rt = new RJ45Test(dutSocket);
        ut = new USBTest(dutSocket);
    }
    
    
    
    private ButtonTest bt;
    private LEDTest lt;
    private RJ45Test rt;
    private USBTest ut;
    
 
}
