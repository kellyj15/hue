/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Translators;

import Database.DBHabitsInterface;
import Database.DBHabitsSql;
import Model.Habit;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author luod1
 */
public class HabitsApapter implements HabitsInterface{
    
    DBHabitsInterface habits =  new DBHabitsSql();

    @Override
    public List<Habit> getAll(String _name) {
        return habits.getAll(_name);
    }

    @Override
    public List<Habit> getActiveHabits(String _name, String _active) {
       return habits.getActiveHabits(_name, _active);
    }

    @Override
    public boolean insertHabit(Habit _habit) {
        return habits.insertHabit(_habit);
    }

    @Override
    public Habit getHabit(int _key) {
       return habits.getHabit(_key);
    }

    @Override
    public List<Habit> getRanking() {
        return habits.getRanking();
    }

    @Override
    public boolean updateHabit(Habit _h) {
        return habits.updateHabit(_h);
    }

    @Override
    public boolean updateHabitDays(int _daypush, int _key, Date _streakTime) {
        return habits.updateHabitDays(_daypush, _key, _streakTime);
    }

    @Override
    public boolean updateMaxHabitDays(int _maxDay, int _key) {
        return habits.updateMaxHabitDays(_maxDay, _key);
    }

    @Override
    public boolean activeHabit(int _key) {
        return habits.activeHabit(_key);
    }

    @Override
    public boolean deleteHabit(int _key) {
        return habits.deleteHabit(_key);
    }
    
}
