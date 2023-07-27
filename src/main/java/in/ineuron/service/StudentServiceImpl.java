package in.ineuron.service;

import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentDaoFactory;

public class StudentServiceImpl implements IStudentService {
    IStudentDao studentDao ;
    @Override
    public String save(Student student) {
        studentDao= StudentDaoFactory.getStudentDao();
        System.out.println("Implementation class name is :: "+ studentDao.getClass().getName());
        return studentDao.save(student);
    }

    @Override
    public Student findByID(Integer sid) {
        studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.findByID(sid);
    }

    @Override
    public String updateByID(Student student) {
        studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.updateByID(student);
    }

    @Override
    public String deleteByID(Integer sid) {
        studentDao = StudentDaoFactory.getStudentDao();
        return studentDao.deleteByID(sid);
    }
}
