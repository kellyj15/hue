package Database;

import Model.Habit;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author luod1
 */
public interface DBHabitsInterface {

    public List<Habit> getAll(String _name);

    public List<Habit> getActiveHabits(String _name, String _active);

    public boolean insertHabit(Habit _habit);
    
    public  Habit getHabit(int _key);
    
    public List<Habit> getRanking();
    
    public boolean updateHabit(Habit _h);
    
    public boolean updateHabitDays(int _daypush,int _key,Date _streakTime);
    
    public boolean updateMaxHabitDays(int _maxDay,int _key);
    
    public boolean activeHabit(int _key);
    
    public boolean deleteHabit(int _key);
}
