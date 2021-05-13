package sample;
import sample.connectivity.connectionclass;
import sample.databaseConnection.Connections;

import java.sql.*;
import java.util.logging.Logger;
public class login_security {





        Connection conn;
        public static String roll;
        public login_security() throws SQLException, ClassNotFoundException {
            conn= connectionclass.getconnection();
        }
        public boolean  userlogin(String username,String password){

            PreparedStatement preparedStatement=null;
            ResultSet resultSet=null;
            try {


                String query="select * from user where uname=? and password=?";
                preparedStatement= conn.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                resultSet=preparedStatement.executeQuery();

                System.out.println();
                if(resultSet.next()){
                    roll=resultSet.getString("roll");
                    System.out.println(roll);
                    return true;
                }
                else{

                    return false;}
            } catch (SQLException ex) {
                //  Logger.getLogger(LoginSecurity.class.getName()).log(level.SEVERE, null, ex);
            }

            finally{
                try {
                    preparedStatement.close();
                    resultSet.close();
                }

                catch (Exception ex) {

                }
            }
            return false;
        }
    }


