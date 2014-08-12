/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram;

import testprogram.DutSocket.*;
import testprogram.FileOperation.FileOperation;
import testprogram.CheckCode.CheckCode;
import testprogram.IOTest.*;
import testprogram.Log.*;
import testprogram.Mydas.*;
import testprogram.Sfis.*;
import testprogram.WiFi.*;
import testprogram.WriteCode.*;

import javax.swing.JFrame;
/**
 *
 * @author zfh1005
 */
public class TestProgramJava {
    
    public TestProgramJava(){
        ProgramJFrame pjf = new ProgramJFrame();
        pjf.setTitle("TestProgram");
        pjf.setLocation(200, 200);
        pjf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pjf.setVisible(true);
    }
    
    public void Init(){
        tffi = new FileOperation();
        tssf = new Sfis();
        tsso = new DutSocket();
        tcch = new CheckCode();        
        tiio = new IOTest();
        tllo = new Log();
        tmmy = new Mydas();
        twwi = new WiFi();
        twwr = new WriteCode();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //show UI dialog
        TestProgramJava tpj = new TestProgramJava();
        //init reference class
        tpj.Init();
        
        
        
    }
    
    private testprogram.CheckCode.CheckCode tcch;
    private testprogram.FileOperation.FileOperation tffi;
    private testprogram.IOTest.IOTest tiio;
    private testprogram.Log.Log tllo;
    private testprogram.Mydas.Mydas tmmy;
    private testprogram.Sfis.Sfis tssf;
    private testprogram.DutSocket.DutSocket tsso;
    private testprogram.WiFi.WiFi twwi;
    private testprogram.WriteCode.WriteCode twwr;
}
