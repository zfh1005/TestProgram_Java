/*
 * TestProgramApp.java
 */

package testprogram;
import testprogram.Socket.TcpSocketClient;
import java.io.*;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class TestProgramApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new TestProgramView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override 
    protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of TestProgramApp
     */
    public static TestProgramApp getApplication() {
        return Application.getInstance(TestProgramApp.class);
    }
    
    public int FT_TestProcess(){
        TcpSocketClient DutSocket = new TcpSocketClient();
        try{           
            DutSocket.DutSocketTelnetenable("192.192.1.1", "001122334455", "Gearguy", "Geardog");
            DutSocket.DutSocketConnect("192.168.1.1", 23);
        }
        catch(IOException e){
            return 0;
        }
        return 1;        
    }
    
    public int RC_TestProcess(){
        return 1;        
    } 

    /**
     * Main method launching the application.
     */
    public static void main(String[] args){
        launch(TestProgramApp.class, args);
        TcpSocketClient DutSocket = new TcpSocketClient();
        try{           
            DutSocket.DutSocketConnect("192.168.1.1", 23);
        }
        catch(IOException e){
            return;
        }
    }
}
