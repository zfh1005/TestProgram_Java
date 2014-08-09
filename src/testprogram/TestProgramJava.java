/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testprogram;

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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TestProgramJava tpj = new TestProgramJava();
        
    }
    
}
