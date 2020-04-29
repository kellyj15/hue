package Database;

/**
 * connect the database Mysql, and sql update, sql get result
 * @author dan
 */
import java.sql.*;

public class DatabaseConnect {

    private static final String DBDRIVER = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/habitsreal?zeroDateTimeBehavior=convertToNull";
    private static final String DBUSER = "root";
    private static final String PASSWORD = "root";

    Connection connect = null;
    PreparedStatement stmts = null;
    ResultSet result = null;

    /**
     * *
     * get connect to database
     *
     * @return
     */
    public boolean getConnection() {
        try {
            Class.forName(DBDRIVER);
            this.connect = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
            if (this.connect != null) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    
    /**
     * get update to database
     * @param _sql 
     * @param _obj
     * @return 
     */
    public boolean executeUpdate(String _sql, Object[] _obj) {
        if (getConnection()) {
            try {
                this.stmts = this.connect.prepareStatement(_sql);
                
                if (_obj != null) {
                    for (int i = 0; i < _obj.length; i++) {
                        this.stmts.setObject(i + 1, _obj[i]);
                    }
                }
                int num = this.stmts.executeUpdate();
                if (num > 0) {
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeResource();
            }
        }
        return false;
    }
    /**
     * get result from database
     * @param _sql
     * @param _obj  search key
     * @return 
     */
    public ResultSet executeQuery( String _sql, Object[] _obj) {
        if (getConnection()) {
            try {
                this.stmts = this.connect.prepareStatement(_sql);
                if (_obj!=null) {
                    for( int i =0; i<_obj.length; i++){
                        this.stmts.setObject(i+1, _obj[i]);
                    }
                }
                this.result = this.stmts.executeQuery();
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return this.result;
    }
    /**
     * get result from database without search key
     * @param _sql
     * @return 
     */
    public ResultSet executeQuery(String _sql) {
         if (getConnection()) {
            try {
                this.stmts = this.connect.prepareStatement(_sql);
                this.result = this.stmts.executeQuery();
            }catch (SQLException e) {
            }
        }
        
        return this.result;
     }
    /**
     * close resource
     */
    public void closeResource() {
        if (this.result != null) {
            try {
                this.result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.stmts != null) {
            try {
                this.stmts.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (this.connect != null) {
            try {
                this.connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
