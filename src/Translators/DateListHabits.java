package Translators;

/**
 * method to habits list and covert Date object
 */
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import Model.Habit;


public class DateListHabits {

    public int defualtsZero = 0;
    public int defualtsOne = 1;
    public int defualtsTwo = 2;

    /**
     * Covert Date object to char
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        return LocalDate.ofEpochDay(date.getTime() / 86400000).plusDays(1);
    }

    /**
     * handle habits list and get habit information
     *
     * @param habit
     * @return
     */
    public static Object[][] listToArray(List<Habit> habit) {
        Object[][] data = new Object[habit.size()][];
        int size = habit.size();
        for (int i = 0; i < size; i++) {
            Habit s = habit.get(i);
            Object[] info = new Object[]{s.getId(), s.getTitle(), s.getDescription(), s.getStreakDays(), s.getStreakTime(), s.getIsActive(), s.getMaxStreakDays()};
            data[i] = info;
        }
        return data;
    }

    /**
     * get habit information (user name, habits title, max streak days) for rank
     * @param habit
     * @return
     */
    public static Object[][] listToArray4Rank(List<Habit> habit) {
        Object[][] data = new Object[habit.size()][];
        int size = habit.size();
        for (int i = 0; i < size; i++) {
            Habit s = habit.get(i);
            Object[] info = new Object[]{s.getName(), s.getTitle(), s.getMaxStreakDays()};
            data[i] = info;
        }
        return data;
    }

}
