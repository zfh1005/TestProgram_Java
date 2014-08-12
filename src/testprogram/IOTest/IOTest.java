/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram.IOTest;


/**
 *
 * @author zfh1005
 */
public class IOTest {
    //struct function
    public IOTest(){
        bt = new ButtonTest();
        lt = new LEDTest();
        rt = new RJ45Test();
        ut = new USBTest();
    }
    
    
    
    private ButtonTest bt;
    private LEDTest lt;
    private RJ45Test rt;
    private USBTest ut;
    
}
