package Database;
/**
 *database of habits modify
 * get habits information, insert, update, deleted
 * @author dan
 */
import Model.Habit;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DBHabitsSql extends DatabaseConnect implements DBHabitsInterface {

    /**
     * get habit by user's name
     * save habit at list
     * @param _name
     * @return 
     */
    @Override
    public List<Habit> getAll(String _name) {
        List<Habit> list = new ArrayList<Habit>();
        String sql = "select * from habit where name =? ";
        Object[] obj = {_name};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                Habit habit = new Habit();
                habit.setId(rs.getInt(1));
                habit.setTitle(rs.getString(2));
                habit.setDescription(rs.getString(3));
                habit.setStreakDays(rs.getInt(4));
                habit.setIsActive(rs.getString(5));
                habit.setStreakTime(rs.getDate(7));
                habit.setMaxStreakDays(rs.getInt(8));
                list.add(habit);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get active habit 
     * save them at list
     * @param _name username
     * @param _active status is active
     * @return 
     */
    @Override
    public List<Habit> getActiveHabits(String _name, String _active) {
        List<Habit> list = new ArrayList<Habit>();
        String sql = "select * from habit where name =? and status = ? ";
        Object[] obj = {_name, _active};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                Habit habit = new Habit();
                habit.setId(rs.getInt(1));
                habit.setTitle(rs.getString(2));
                habit.setDescription(rs.getString(3));
                habit.setStreakDays(rs.getInt(4));
                habit.setIsActive(rs.getString(5));
                habit.setStreakTime(rs.getDate(7));
                list.add(habit);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * insert habits to database
     * @param _habit
     * @return 
     */
    @Override
    public boolean insertHabit(Habit _habit) {
        String sql = "INSERT into habit (title,description,streakDays,status,name,streakTime,streak,flag) VALUES (?,?,?,?,?,?,?,?)";
        Object[] obj = {_habit.getTitle(), _habit.getDescription(),
            _habit.getStreakDays(),
            _habit.getIsActive(), _habit.getName(),
            new java.sql.Date(System.currentTimeMillis()), 0, "0"
        };
        boolean insert = this.executeUpdate(sql, obj);
        return insert;

    }

    /**
     * get habit by use id
     * @param _key habit id
     * @return 
     */
    @Override
    public Habit getHabit(int _key) {
        Habit h = new Habit();
        String sql = "select * from habit where id =? ";
        Object[] obj = {_key};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                Habit habit = new Habit();
                habit.setId(rs.getInt(1));
                habit.setTitle(rs.getString(2));
                habit.setDescription(rs.getString(3));
                habit.setStreakDays(rs.getInt(4));
                habit.setIsActive(rs.getString(5));
                habit.setStreakTime(rs.getDate(7));
                habit.setFlag(rs.getString(9));
                h = habit;
            }
            return h;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * order the list of active habits
     * @return 
     */
    @Override
    public List<Habit> getRanking() {
        List<Habit> list = new ArrayList<>();
        String sql = "select * from habit where status = ? order by streak desc";
        Object[] obj = {"Active"};
        ResultSet rs = this.executeQuery(sql, obj);
        try {
            while (rs.next()) {
                Habit habit = new Habit();
                habit.setId(rs.getInt(1));
                habit.setTitle(rs.getString(2));
                habit.setDescription(rs.getString(3));
                habit.setStreakDays(rs.getInt(4));
                habit.setIsActive(rs.getString(5));
                habit.setName(rs.getString(6));
                habit.setMaxStreakDays(rs.getInt(8));
                list.add(habit);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * update the habit information
     * @param _h
     * @return 
     */
    @Override
    public boolean updateHabit(Habit _h) {
        String sql = "UPDATE habit set title=?,description=?,streakDays=?,status=? where id =?";
        Object [] obj = {_h.getTitle(), _h.getDescription(),
        _h.getStreakDays(), _h.getIsActive(), _h.getId()};
        
        boolean update = this.executeUpdate(sql, obj);
        return update;
    }
    
    /**
     * update the streak days
     * @param _daypush
     * @param _key
     * @param _streakTime
     * @return 
     */
    @Override
    public boolean updateHabitDays(int _daypush, int _key, Date _streakTime) {
        String sql = "UPDATE habit set streakDays=?,streakTime=?,flag='1' where id =?"; 
        Object[] obj = {_daypush, _streakTime, _key};
        boolean update = this.executeUpdate(sql, obj);
        return update;
    }

    /**
     * update the max streak days
     * @param _maxDay
     * @param _key
     * @return 
     */
    @Override
    public boolean updateMaxHabitDays(int _maxDay, int _key) {
        String sql = "UPDATE habit set streak=? where id =?";
        Object[] obj ={_maxDay, _key};
        boolean update = this.executeUpdate(sql, obj);
        return update;
    
    }

    /**
     * change habit status to active
     * @param _key
     * @return 
     */
    @Override
    public boolean activeHabit(int _key) {
        String active = "Active";
        String sql = "UPDATE habit set status=?  where id =?";
        Object[] obj = {active,_key};
        boolean update = this.executeUpdate(sql, obj);
        return update;
    }

    /**
     * delete the habit
     * @param _key
     * @return 
     */
    @Override
    public boolean deleteHabit(int _key) {
        String sql = "DELETE FROM habit where id =?";
        Object[] obj = {_key};
        boolean delete = this.executeUpdate(sql, obj);
        return delete;
    }

}
