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
    
/***
 * user signed or not 
 * @return 
 */
    
    private static int SignDay(){
        
        Integer dayKept=1;
        
        boolean isSignIn = false;
        
        String sign;
        //hashtable to store user is Signed or not
        Hashtable<Integer, String> data = new Hashtable<>();
        
        //get today date
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
        String dateString = sdf.format(today);
        
        try{
            //get today sign information 
            SignDetail signToday;
            if (signToday == null){
                //get yesterday sign information
                if(yesterday == null){
                    
                }else{
                    
                }
            }else{//
              isSignIn=true;
              sign="signed success";
              data.put(dayKept,sign);
            }
                
            
        }
    }
}
