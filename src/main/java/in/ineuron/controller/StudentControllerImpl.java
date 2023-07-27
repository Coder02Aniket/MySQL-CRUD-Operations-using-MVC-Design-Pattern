package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;


public class StudentControllerImpl implements IStudentController {
    IStudentService stdService ;
    @Override
    public String save(Student student) {
        stdService = StudentServiceFactory.getStudentService();
        System.out.println("Implementation class is ::"+ stdService.getClass().getName());
        return stdService.save(student);

    }

    @Override
    public Student findByID(Integer sid) {
        stdService = StudentServiceFactory.getStudentService();
        return stdService.findByID(sid);
    }

    @Override
    public String updateByID(Student student) {
        stdService = StudentServiceFactory.getStudentService();
        return stdService.updateByID(student);
    }

    @Override
    public String deleteByID(Integer sid) {
        stdService = StudentServiceFactory.getStudentService();
        return stdService.deleteByID(sid);
    }
}
