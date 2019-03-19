package money.studen_homework;

import java.util.List;
import java.util.stream.Collectors;

public class Controller implements IController {

  IService service;
  IResponse response;

  public Controller() {
    service = new Service();
    response = new StudentResponseString();
  }

  @Override
  public IService getService() {
    return service;
  }

  @Override
  public void setService(IService service) {
    this.service = service;
  }

  @Override
  public IResponse getResponse() {
    return response;
  }

  @Override
  public void setResponse(IResponse response) {
    this.response = response;
  }

  @Override
  public IResponse getStudent(Student student) {
    StudentResponseString response = new StudentResponseString();
    if (null == student.getPID() || "".equals(student.getPID())) {
      response.setResponseCode(400);
      response.setResponseString("BAD_REQUEST");
      return response;
    }
    Student result = service.getStudent(student);
    if (null == result) {
      response.setResponseCode(404);
      response.setResponseString("NOT_FOUND");
      return response;
    } else {
      response.setResponseCode(200);
      response.setResponseString("OK");
      response.setContent(result.toString());
      return response;
    }
  }

  @Override
  public IResponse addStudent(Student student) {
    StudentResponseString response = new StudentResponseString();

    String PID = student.getPID();
    List<String> PIDList = service.getAllStudent().stream().map(Student::getPID)
        .collect(Collectors.toList());
    if (null == PID) {
      if (null == student.getName() || null == student.getEmail() || "".equals(student.getEmail())
          || "".equals(student.getName())) {
        response.setResponseCode(400);
        response.setResponseString("BAD_REQUEST");
        return response;
      } else {
        boolean b = service.addStudent(student);
        response.setResponseCode(201);
        response.setResponseString("CREATED");
        return response;
      }
    } else {
      if (PIDList.contains(PID)) {
        service.updateStudent(student);
        response.setResponseCode(202);
        response.setResponseString("ACCEPTED");
        return response;
      } else {
        service.addStudent(student);
        response.setResponseCode(201);
        response.setResponseString("CREATED");
        return response;
      }
    }
  }

  @Override
  public IResponse removeStudent(Student student) {
    StudentResponseString response = new StudentResponseString();
    //删除学生
    boolean b = service.removeStudent(student);
    response.setResponseCode(200);
    response.setResponseString("OK");
    return response;
  }

  @Override
  public IResponse updateStudent(Student student) {
    if (student.getPID() == null) {
      response.setResponseCode(400);
      response.setResponseString("BAD_REQUEST");
      return response;
    }
    boolean b = service.updateStudent(student);
    if (b) {
      StudentResponseString response = new StudentResponseString();
      response.setResponseCode(200);
      response.setResponseString("OK");
    } else {
      response.setResponseCode(404);
      response.setResponseString("NOT_FOUND");
      return response;
    }
    return response;
  }

  @Override
  public IResponse getAllStudent() {
    StudentResponseString response = new StudentResponseString();

    List<Student> students = service.getAllStudent();

    response.setResponseCode(200);
    response.setResponseString("OK");
    response.setListContent(students.toString());
    return response;
  }
}
