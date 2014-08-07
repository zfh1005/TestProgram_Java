/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.File;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
import testprogram.FailedValueDefine;

/**
 *
 * @author cq
 */
public class SettingFileOperate {
    FailedValueDefine FailedValueDefine = new FailedValueDefine();
    
    public int FileStatusCheck(String PathName){
        File FileOperaterCheck = new File(PathName);
        if(FileOperaterCheck.isDirectory()){
            return FailedValueDefine.iFileNameIsDirectory;
        }
        if(!FileOperaterCheck.exists()){
            return FailedValueDefine.iFileIsNotExist;
        }
        
        return FailedValueDefine.iPASS;   
    }
    
    /*
     * 功能：检查关键字是否存在
     * 输入：(String 文件名，String 关键字)
     * 输出：存在：true
     *       不存在：false
     */
    public boolean CheckKeywordInFile(String FileName, String KeyWord){
        boolean bKeyWordFindInFile = false;  
        try {
            File file = new File(FileName);
            InputStream is = new FileInputStream(new File(FileName));  
            //FileReader fr = new FileReader(FileName); 
            //BufferedReader br = new BufferedReader(new FileReader(FileName));
            long FileBufferLength = file.length();
            
            byte[] FileBuffer = new byte[(int)(FileBufferLength + 1)];
            
            //char FileBuffer[FileBufferLength] ;
            is.read(FileBuffer);
            if(FileBuffer.toString().contains(KeyWord)){                
                bKeyWordFindInFile = true;
            } 
            is.close();            
        } 
        catch (Exception ex) {
            Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  bKeyWordFindInFile ;  
    }
    
    /*
     * 功能：从行区分的文件中根据keyword获取设定值
     * 输入：(String 文件名，String 关键字)
     * 输出：String 设定值
     */
    public String FromSettingFileUseKeywordGetSettingValue(String FileName, String KeyWord){        
        String SetingValue = null;
        BufferedReader reader = null;    
        
        int iFileNameCheckStatus = FileStatusCheck(FileName);
        //Check Status
        if(iFileNameCheckStatus !=  FailedValueDefine.iPASS){
            return "File Status Check Failed";
        } 
        
        //get setting value
        try {
            reader = new BufferedReader(new FileReader(FileName));
            String str = null;            
            while ((str = reader.readLine()) != null) {
                if(str.startsWith(KeyWord)){                    
                    
                    /*
                     * The Setting Value Format is:                    
                     * KeyWord = SeetingValue                    
                     */                    
                    String[] ResultString = str.split("=");  
                    
                    /*
                     * ResultString is [keyword, setingValue]   
                     * So the index is : [1]
                     */
                    if(ResultString[0].equals(KeyWord)){
                        SetingValue =  ResultString[1]; 
                    }
                } 
                else{
                    continue;
                }                 
            }            
        }
        catch(Exception e){   
            Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
            if (reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e1) {
                    Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, e1);
                }
            }
        }        
        return SetingValue;
    }
    
    
    public String WriteSettingValueToSettingFile(String FileName, String KeyWord, String SettingValue){        
       
        String WriteBuffer = null;   
        
        int iFileNameCheckStatus = FileStatusCheck(FileName);
        //Check Status
        if(iFileNameCheckStatus !=  FailedValueDefine.iPASS){
            return "File Status Check Failed";
        }
        
        //check at file is have "keyword" or not
        //boolean bKeyWordFindInFile = false;        
        //bKeyWordFindInFile = CheckKeywordInFile(FileName, KeyWord);       
        
        BufferedReader reader = null; 
        //get file oldline 
        //concat to newline            
        try {
            reader = new BufferedReader(new FileReader(FileName));
            String str = null;            
            while ((str = reader.readLine()) != null) {
                String[] ResultString = str.split("=");
                if(ResultString[0].equals(KeyWord)){
                    String NewLine = null;
                    NewLine = KeyWord + "=" + SettingValue;
                    WriteBuffer.concat(NewLine);
                }
                else{
                    WriteBuffer.concat(str);
                }
            }
        }
        catch(Exception e){            
        }
        finally{
            if (reader != null) {
                try {
                    reader.close();
                } 
                catch (IOException e) {
                    Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        //delete old file
        File fileCheckKeywordFind = new File(FileName);
        fileCheckKeywordFind.delete();            
          
        //write new file
        try { 
            FileWriter fw = new FileWriter(FileName);                   
            //OutputStream os = new FileOutputStream(new File(FileName));             
            //BufferedWriter bw = new BufferedWriter(new FileWriter(FileName));            
            fw.write(WriteBuffer);
            this.wait(1000);
            fw.close();            
        } 
        catch (Exception ex) {
            Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return "PASS";       
    }
    
    public String FromSettingFileUseSectionNameKeywordGetSettingValue(String FileName, String SectionName, String keyword){
        String SetingValue = null;
        
        int iFileNameCheckStatus = FileStatusCheck(FileName);
        //Check Status
        if(iFileNameCheckStatus !=  FailedValueDefine.iPASS){
            return "File Status Check Failed";
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            String str = null;   
            boolean bSectionNameIsFound = false;
            
            Pattern p; 
            Matcher m; 
            
            p = Pattern.compile("file://[//s*" + SectionName + "file://s*//]");
            m = p.matcher(str);
            
            while ((str = br.readLine()) != null) {
                m = p.matcher(str);
                if(m.matches()){
                    bSectionNameIsFound = true;                
                }
                if(bSectionNameIsFound == true){
                    if(str.startsWith(keyword)){
                        String[] ResultString = str.split("="); 
                        /*
                         * ResultString is [keyword, setingValue]   
                         * So the index is : [1]
                         */                    
                        SetingValue =  ResultString[1];
                        break;
                    }
                }  
            } 
        }
        catch (Exception ex) {
            Logger.getLogger(SettingFileOperate.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return SetingValue;        
    }
    
    public static void main(String[] args){
        SettingFileOperate SettingFileOperate = new SettingFileOperate();
        SettingFileOperate.WriteSettingValueToSettingFile("C:/TFTP_Status.ini", "SENDOK1", "999");        
    }
}

       

