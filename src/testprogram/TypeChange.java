/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testprogram;

/**
 *
 * @author cq
 */
public class TypeChange {
    
    /*
     * String type change to int type     
     */
    public static int StringToInt(String StringValue){
        Integer integer;
        integer = Integer.valueOf(StringValue);
        return integer.intValue();
    }
    
    /*
     * int type change to String type     
     */
    public static String IntToString(int IntValue){
        Integer integer = new Integer(IntValue);
        return integer.toString();        
    }
    
    /*
     * String type change to float type     
     */
     public static float StringToFloat(String StringValue){
         Float floatee;
         floatee = Float.valueOf(StringValue);
         return floatee.floatValue();  
     }
     
    /*
     * flaot type change to String type     
     */
     public static String FloatToString(float FloatValue){
         Float floatee = new Float(FloatValue);
         return floatee.toString();  
     }
     
    /*
     * String type change to SQL Date type     
     */
     public static java.sql.Date StringToSqlDate(String StringValue){
         return java.sql.Date.valueOf(StringValue);
     }
     
    /*
     * SQL Date type change to String type     
     */ 
     public static String SqlDateToString(java.sql.Date DateValue){
         return DateValue.toString();
     }
     
    /*
     * String type change to Double type     
     */
     public static double StringToDouble(String StringValue){
         Double doublee;
         doublee = Double.valueOf(StringValue);
         return doublee.doubleValue();
     }
     
    /*
     * Double type change to String type     
     */
     public static String DoubleToString(double DoubleValue){
         Double doublee = new Double(DoubleValue);
         return doublee.toString();  
     }   
     
}
