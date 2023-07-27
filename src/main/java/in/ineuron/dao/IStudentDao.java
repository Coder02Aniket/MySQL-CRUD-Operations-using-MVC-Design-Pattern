package in.ineuron.dao;

import in.ineuron.dto.Student;

public interface IStudentDao {
    String save(Student student);//For create operation of DataBase
    Student findByID(Integer sid);//Reading a record by ID
    String updateByID(Student student);//Updating a record
    String deleteByID(Integer sid);//Deleting a record
}
