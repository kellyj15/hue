package Model;

import java.util.Date;

/**
 * @auther: dan
 * @date: 2020/3/17 11:32
 * @description:
 */
public class BadHabit extends Habit {

    private String classify;//
    private Date startTime;//
    private String current;//
    private String userId;//

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



}
