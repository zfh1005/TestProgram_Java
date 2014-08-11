/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram.FileOperation;

import jdk.nashorn.internal.runtime.Logging;
import testprogram.FailedValueDefine;

/**
 *
 * @author zfh1005
 */
public class ReadSettingValue {

    public ReadSettingValue() {
        getValue = new ReadValue();
        FailedValueDefine = new FailedValueDefine();
    }

    //paser vaule
    public String parseSettingValue(String FileName, String keyWord) {
        String result = null;
        if (FileName == null) {
            Logging.getLogger("The parameter FileName:" + FileName + "is empty.");
            return result;
        }
        if (keyWord == null) {
            Logging.getLogger("The parameter keyWord:" + keyWord + "is empty.");
            return result;
        }
        
        if(getValue.FileStatusCheck(FileName) != FailedValueDefine.iPASS){
            Logging.getLogger("The parameter FileName:" + FileName + "is error.");
            return result;
        }
        
        if(getValue.CheckKeywordInFile(FileName, keyWord) != true){
            Logging.getLogger("The parameter keyWord:" + keyWord + "is error.");
            return result;
        }
        
        result = getValue.FromSettingFileUseKeywordGetSettingValue(FileName, keyWord);
        
        return result;
    }
    
     //paser vaule
    public String parseSettingValue(String FileName, String SectionName, String keyWord) {
        String result = null;
        if (FileName == null) {
            Logging.getLogger("The parameter FileName:" + FileName + "is empty.");
            return result;
        }
        if (keyWord == null) {
            Logging.getLogger("The parameter keyWord:" + keyWord + "is empty.");
            return result;
        }
        
        if(getValue.FileStatusCheck(FileName) != FailedValueDefine.iPASS){
            Logging.getLogger("The parameter FileName:" + FileName + "is error.");
            return result;
        }
        
        if(getValue.CheckKeywordInFile(FileName, keyWord) != true){
            Logging.getLogger("The parameter keyWord:" + keyWord + "is error.");
            return result;
        }
        
        result = getValue.FromSettingFileUseSectionNameKeywordGetSettingValue(FileName, SectionName, keyWord);
        
        return result;
    }

    private ReadValue getValue;
    private FailedValueDefine FailedValueDefine;

}
