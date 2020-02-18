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
    private boolean active;
    //Short description of the habit.
    private String description;
    //Number of days in a row that a habit was kept.
    private int streakDays;
    //A list of dates in which this habit was kept, sorted from earliest to latest.
    //TODO - Ensure that daysKept remains sorted upon add operation.
    private ArrayList<LocalDate> daysKept;
    //File path to an icon that can be used in the UI to represent this habit.
    private String imagePath;
    //Default Habit title
    private static String defaultTitle = "New Habit";
    //Default habit description
    private static String defaultDesc = "No Description";

    /**
     * Constructor when a habit title and description is given.
     * @param _title - The Title of the habit.
     * @param _desc - The description of the habit.
     */
    public Habit(String _title, String _desc) {
        this.title = _title;
        this.description = _desc;
        this.active = true;
        this.streakDays = 0;
        this.daysKept = new ArrayList<>();
        this.imagePath = null;
    }

    /**
     * Constructor when a title and description are not given.
     */
    public Habit() {
        this(defaultTitle, defaultDesc);
    }

    /**
     * Constructor when only the title is given.
     * @param _title - Title of the habit.
     */
    public Habit(String _title) {
        this(_title, defaultDesc);
    }

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
        return this.active;
    }

    public String getDescription() {
        return this.description;
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

    public void setActive(boolean _active) {
        this.active = _active;
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