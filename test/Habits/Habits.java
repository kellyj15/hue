package Habits;
import java.text.SimpleDateFormat;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dan
 */
public abstract class Habits {
    private String title;
    private boolean active;
    private String descriptions;
    private int streakDays;
    private int dayKept;
    
/***
 * day signed or not 
 * todaysign is object, to get sign information 
 * @return 
 */
    
    private static int Signday(todaysign){
        
        
        
        boolean isSignIn = false;
        
        //hashtable to store user is Signed or not
        Hashtable signed = new Hashtable();
        //Enumeration date = signed.keys();
        //get today date
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(today);
        
        try{
            //today not sign 
            if(todaysign == null ){
            
                isSignIn=false;
                dayKept=dayKept+0;
             
            }else{//if today signed
              isSignIn=true;
              signed.put(dateString,isSignIn);
              dayKept++;
            }
                
        }catch (Exception e) {
            // TODO generated catch block
            e.printStackTrace();

    }
}
