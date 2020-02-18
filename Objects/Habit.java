package Objects;
/**
 * Class to represent an abstract habit.
 * Date last edited: 2-18-2019
 * @author dan
 * @author Jesse Carter
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Habit {
    //Title of a given habit
    private String title;
    //Whether or not the habit is being actively tracked.
    private boolean isActive;
    //Short description of the habit.
    private String description;
    //Is this a good habit or a bad habit?
    private boolean isGood;
    //Number of days in a row that a habit was kept.
    private int streakDays;
    //A list of dates in which this habit was kept, sorted from earliest to latest.
    //TODO - Ensure that daysKept remains sorted upon add operation.
    private ArrayList<LocalDate> daysKept;
    //File path to an icon that can be used in the UI to represent this habit.
    private String imagePath;
    //Default Habit title if not specified.
    private static String defaultTitle = "New Habit";
    //Default habit description if not specified.
    private static String defaultDesc = "No Description";
    //Set habit to a good habit if not specified.
    private static boolean defaultIsGood = true;
    //Set the habit to be tracked upon creation until the user makes a change.
    private static boolean defaultIsActive = true;

    /**
     * Constructor when a habit title and description is given.
     * @param _title - The Title of the habit.
     * @param _description - The description of the habit.
     * @param _isGood Is this habit a good or bad habit?
     */
    public Habit(String _title, String _description, boolean _isGood) {
        this.title = _title;
        this.description = _description;
        this.isActive = defaultIsActive;
        this.isGood = _isGood;
        this.streakDays = 0;
        this.daysKept = new ArrayList<>();
        this.imagePath = null;
    }

    /**
     * Constructor when a title and description are not given.
     */
    public Habit() {
        this(defaultTitle, defaultDesc, defaultIsGood);
    }

    /**
     * Constructor when only the title is given.
     * @param _title - Title of the habit.
     */
    public Habit(String _title) {
        this(_title, defaultDesc, defaultIsGood);
    }

    /**
     * Method to calculate the current streak, in days, that this habit has been kept.
     * TODO: update method to allow for habits which are kept once every x days instead of only every day.
     * TODO: update to allow for habits to be kept on certain days of the week, such as every MWF.
     * @return the number of days a habit has been kept in a row. A day in which a habit was not kept breaks this streak.
     */
    public int calculateStreakDays() {
        //Set streak to zero to start.
        int streak = 0;
        //If the daysKept list is empty, return zero as the streak.
        if (this.daysKept.isEmpty()) {
            return streak;
        }
        //Get the current date.
        LocalDate today = LocalDate.now();
        //Step back through daysKept until there is a change of more than one day, incrememnting streak.
        for (int i = this.daysKept.size() - 1; i >= 0; i--) {
            if (this.daysKept.get(i).plusDays(1).equals(today) ) {
                //The most recent day the habit was kept was one day before current. Add to streak and continue.
                streak++;
                today = this.daysKept.get(i);
            } else {
                //There is more than one day apart between days the habit was kept. Report the current streak total.
                return streak;
            }
        }
        return streak;
    }

//==========================GETTERS==========================

    public String getTitle() {
        return this.title;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean isGood() {
        return this.isGood;
    }

    public int getStreakDays() {
        return this.streakDays;
    }

    public ArrayList getDaysKept() {
        return this.daysKept;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public static String getDefaultTitle() {
        return defaultTitle;
    }

    public static String getDefaultDesc() {
        return defaultDesc;
    }

//==========================SETTERS==========================

    public void setTitle(String _title) {
        this.title = _title;
    }

    public void setActive(boolean _isActive) {
        this.isActive = _isActive;
    }

    public void setIsGood(boolean _isGood) {
        this.isGood = _isGood;
    }

    public void setDescription(String _description) {
        this.description = _description;
    }

    public void setStreakDays(int _streakDays) {
        this.streakDays = _streakDays;
    }

    public void setDaysKept(ArrayList _daysKept) {
        this.daysKept = _daysKept;
    }

    public void setImagePath(String _imagePath) {
        this.imagePath = _imagePath;
    }

}