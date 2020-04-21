package Model;

/**
 * Class to represent habit. 
 *
 * @author dan
 * @author Jesse Carter
 */

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class Habit {

    private int id;
    //Title of a given habit
    private String title;
    //Whether or not the habit is being actively tracked.
    private String isActive;
    //Short description of the habit.
    private String description;
    
    private int streakDays;
    //A list of dates in which this habit was kept, sorted from earliest to latest.
    //TODO - Ensure that daysKept remains sorted upon add operation.
    
    //username
    private String name;
    //the habit max streak days
    private int maxStreakDays;
    //the flag for check date
    private String flag;
    //the date of check 
    private Date streakTime;

    /**
     * Constructor when a habit information is given or not given
     */

    public Habit(){

    }
    
    public Habit(int _id, String _title, String _description, int _streakDays, String _isActive) {
        this.id = _id;
        this.title = _title;
        this.description = _description;
        this.streakDays = _streakDays;
        this.isActive = _isActive;
    }

    public Habit(String _title, String _description, int _streakDays, String _isActive, String _name) {

        this.title = _title;
        this.description = _description;
        this.streakDays = _streakDays;
        this.isActive = _isActive;
        this.name = _name;
    }
     

    /**
     * Method to calculate the current streak, in days, that this habit has been
     * kept. TODO: update method to allow for habits which are kept once every x
     * days instead of only every day. TODO: update to allow for habits to be
     * kept on certain days of the week, such as every MWF.
     *
     * @return the number of days a habit has been kept in a row. A day in which
     * a habit was not kept breaks this streak.
     */
   /**
    * public int calculateStreakDays() {
      
      * //Set streak to zero to start.
        int streak = 0;
        //If the daysKept list is empty, return zero as the streak.
        if (this.daysKept.isEmpty()) {
            return streak;
        }
        //Get the current date.
        LocalDate today = LocalDate.now();
        //Step back through daysKept until there is a change of more than one day, incrememnting streak.
        for (int i = this.daysKept.size() - 1; i >= 0; i--) {
            if (this.daysKept.get(i).plusDays(1).equals(today)) {
                //The most recent day the habit was kept was one day before current. Add to streak and continue.
                streak++;
                today = this.daysKept.get(i);
            } else {
                //There is more than one day apart between days the habit was kept. Report the current streak total.
                return streak;
            }
        }
        return streak;
     * @return }*/

//==========================GETTERS==========================
    public String getTitle() {
        return this.title;
    }

    public String getIsActive() {
        return this.isActive;
    }

    

    public String getDescription() {
        return this.description;
    }

    //public boolean isGood() {
      //  return this.isGood;
    //}

    public int getStreakDays() {
        return this.streakDays;
    }

    //public ArrayList getDaysKept() {
     //   return this.daysKept;
    //}

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxStreakDays() {
        return this.maxStreakDays;
    }

    public String getFlag() {
       return this.flag;
   }

    public Date getStreakTime() {
        return streakTime;
    }
    
    
//==========================SETTERS==========================
    public void setStreakTime(Date streakTime) {
        this.streakTime = streakTime;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    

    //public void setIsGood(boolean _isGood) {
      //  this.isGood = _isGood;
    //}

    public void setDescription(String _description) {
        this.description = _description;
    }

    public void setStreakDays(int _streakDays) {
        this.streakDays = _streakDays;
    }

    //public void setDaysKept(ArrayList _daysKept) {
    //    this.daysKept = _daysKept;
    //}

    public void setId(int _id) {
        this.id = _id;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setMaxStreakDays(int _maxStreakDats) {
        this.maxStreakDays = _maxStreakDats;
    }

    public void setFlag(String _flag) {
        this.flag = _flag;
    }

}
