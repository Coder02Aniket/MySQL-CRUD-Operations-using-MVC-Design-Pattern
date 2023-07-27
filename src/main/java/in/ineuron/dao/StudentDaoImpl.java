package in.ineuron.dao;

import in.ineuron.dto.Student;
import in.ineuron.util.JdbcUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements IStudentDao {
    Connection connection ;
    @Override
    public String save(Student student) {
        String sqlInsertQuery = "insert into ServletData(name,email,city,country) values(?,?,?,?)";
        PreparedStatement pstmt =null;
        try{
            connection = JdbcUtil.getJdbcConnection();
            if(connection!=null)
                pstmt = connection.prepareStatement(sqlInsertQuery);
            if(pstmt!=null){
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getEmail());
                pstmt.setString(3,student.getCity());
                pstmt.setString(4, student.getCountry());

                 int rowAffected = pstmt.executeUpdate();
                 if(rowAffected==1)
                     return "Success";
                 else{
                     return "Failure";
                 }

            }


        }catch(SQLException | IOException e){
            e.printStackTrace();
            return "failure";
        }
        return "Something Snapped!!!!";
    }

    @Override
    public Student findByID(Integer sid) {
        String selectQuery = "select sid , name , email,city , country from servletdata where sid = ?";
        PreparedStatement pstmt = null;
        Student student = null ;
        try{
            connection = JdbcUtil.getJdbcConnection();
            if(connection!=null){
                pstmt = connection.prepareStatement(selectQuery);

            }
            if(pstmt!=null){
                pstmt.setInt(1,sid);
            }
            if(pstmt!=null){
                ResultSet rs = pstmt.executeQuery();

                if(rs.next()){
                    student =new Student();
                    student.setSid(rs.getInt(1));
                    student.setName(rs.getString(2));
                    student.setEmail(rs.getString(3));
                    student.setCity(rs.getString(4));
                    student.setCountry(rs.getString(5));
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public String updateByID(Student student) {
        String sqlUpdateQuery = "update servletdata set name =? , email = ? , city = ? , country = ? where sid = ? ";
        PreparedStatement pstmt = null ;
        String status = null ;
        try {
            connection = JdbcUtil.getJdbcConnection();
            if (connection != null) {
                pstmt = connection.prepareStatement(sqlUpdateQuery);

            }
            if (pstmt != null) {
                pstmt.setString(1, student.getName());
                pstmt.setString(2, student.getEmail());
                pstmt.setString(3, student.getCity());
                pstmt.setString(4, student.getCountry());
                pstmt.setInt(5, student.getSid());
            }
            if(pstmt!=null){
                int rowAffected = pstmt.executeUpdate();
                if(rowAffected==1){
                    status = "success";
                }else{
                    status = "failure";
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public String deleteByID(Integer sid) {
        String sqlDeleteQuery = "Delete from servletdata where sid = ?";
        PreparedStatement pstmt = null ;
        String status = null ;
        try{
            Student student = findByID(sid);
            if(student!=null){
                connection = JdbcUtil.getJdbcConnection();
                if(connection!=null){
                    pstmt = connection.prepareStatement(sqlDeleteQuery);
                }
                if(pstmt!=null){
                    pstmt.setInt(1,sid);
                    int rowAffected = pstmt.executeUpdate();
                    if(rowAffected==1){
                        status = "success";
                    }
                }
            }else{
                status = "Not Available";
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return status ;


    }
}
