package in.ineuron.main;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestApp {
    public static void main(String[] args) {

        IStudentController studentController =null  ;
        Integer id = null ;
        Student studentRecord = null ;

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("1.CREATE");
                System.out.println("2.READ");
                System.out.println("3.UPDATE");
                System.out.println("4.DELETE");
                System.out.println("5.EXIT");
                System.out.println("Your option :: [1,2,3,4,5]");
                Integer option = Integer.parseInt(br.readLine());
                studentController = StudentControllerFactory.getStudentController();
                switch (option) {
                    case 1:
                        System.out.println("Enter the name :: ");
                        String name = br.readLine();
                        System.out.println("Enter the city");
                        String city = br.readLine();
                        System.out.println("Enter the email");
                        String email = br.readLine() ;
                        System.out.println("Enter the country ");
                        String country = br.readLine();


                        Student student  = new Student();
                        student.setName(name);
                        student.setCountry(country);
                        student.setEmail(email);
                        student.setCity(city);
                        String status = studentController.save(student);
                        if(status.equalsIgnoreCase("success")){
                            System.out.println("Record Inserted Sucessfully!!!");
                        }else if(status.equalsIgnoreCase("Failure")){
                            System.out.println("Record Insertion failed");
                        }else{
                            System.out.println("Some unknown problem occurred");
                        }
                        break;

                    case 2:
                        System.out.println("Enter the id :: ");
                        id = Integer.parseInt(br.readLine());
                        studentRecord = studentController.findByID(id);
                        if (studentRecord != null) {
                            System.out.println(studentRecord);
                        } else {
                            System.out.println("Record Not Found");
                        }
                        break;

                    case 3:
                        System.out.println("Enter the id :: ");
                        id = Integer.parseInt(br.readLine());
                        studentRecord = studentController.findByID(id);
                        if (studentRecord != null) {
                            Student new_student = new Student();
                            new_student.setSid(studentRecord.getSid());
                            System.out.println("StudentName is :: [Old Name is "+studentRecord.getName()+"]");
                            String new_name = br.readLine();
                            if(new_name.equals(" ")||new_name.isEmpty()){
                                new_student.setName(studentRecord.getName());
                            }else{
                                new_student.setName(new_name);

                            }

                            System.out.println("Student Email is :: [Old Email is "+studentRecord.getEmail()+"]");
                            String n_email = br.readLine();
                            if(n_email.equals(" ")|| n_email.isEmpty()){
                                new_student.setEmail(studentRecord.getEmail());
                            }else{
                                new_student.setEmail(n_email);
                            }

                            System.out.println("Student city  is :: [Old city is "+studentRecord.getCity()+"]");
                            String n_city = br.readLine();
                            if(n_city.equals(" ")||n_city.isEmpty()){
                                new_student.setCity(studentRecord.getCity());
                            }else{
                                new_student.setCity(n_city);

                            }

                            System.out.println("Student country is :: [Old country is "+studentRecord.getCountry()+"]");
                            String n_country = br.readLine();
                            if(n_country.equals(" ")||n_country.isEmpty()){
                                new_student.setCountry(studentRecord.getCountry());
                            }else{
                                new_student.setCountry(n_country);
                            }
                            status = studentController.updateByID(new_student);
                            System.out.println(new_student);
                            if(status.equalsIgnoreCase("success")){
                                System.out.println("Record Updated Successfully");
                            } else if (status.equalsIgnoreCase("failure")) {
                                System.out.println("Record Update failed");
                            }else{
                                System.out.println("Some problem occurred");
                            }
                        } else {
                            System.out.println("Record Not Found");
                        }
                        break;

                    case 4:

                        System.out.println("Enter the id :: ");
                        id = Integer.parseInt(br.readLine());

                        status = studentController.deleteByID(id);

                        if(status.equalsIgnoreCase("success")){
                            System.out.println("record added sucessfully");
                        }else if(status.equalsIgnoreCase("failure")){
                            System.out.println("record deletion failed");
                        }else{
                            System.out.println("Id not available ");
                        }
                        break;

                    case 5 :
                        System.out.println("Thanks for using the application ");
                        System.exit(0);
                    default:
                        System.out.println("Please enter the option like 1 ,2 , 3, 4, 5 for operation");
                        break;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }

}
