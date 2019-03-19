package money.studen_homework;

import java.util.List;
import java.util.stream.Collectors;

public class Service implements IService {

  IDatabase database;

  public Service() {
    database = new Database();
  }

  @Override
  public void loadDb() {

  }

  @Override
  public void updateDb() {

  }

  @Override
  public Student getStudent(Student student) {
    List<Student> students = (List<Student>) database.loadDb();
    for (Student student1 : students) {
      if (student.equals(student1)) {
        return student1;
      }
    }
    return null;
  }

  @Override
  public boolean addStudent(Student student) {
    List<Student> students = (List<Student>) database.loadDb();
    String PID = student.getPID();
    List<String> PIDList = students.stream().map(Student::getPID)
        .collect(Collectors.toList());
    if (null == PID) {
      int max = 0;
      for (int i = 0; i < students.size(); i++) {
        if (Integer.valueOf(students.get(i).getPID()) > max) {
          max = Integer.valueOf(students.get(i).getPID());
        }
      }
      student.setPID(String.valueOf(max + 1));
      students.add(student);
      database.updateDb(students);
      return true;
    } else {
      if (PIDList.contains(PID)) {
        updateStudent(student);
        return false;
      } else {
        students.add(student);
        database.updateDb(students);
        return true;
      }
    }
  }

  @Override
  public boolean removeStudent(Student student) {
    List<Student> students = (List<Student>) database.loadDb();
    students.remove(student);
    database.updateDb(students);
    return true;
  }

  @Override
  public boolean updateStudent(Student student) {
    List<Student> students = (List<Student>) database.loadDb();
    List<String> PIDList = students.stream().map(Student::getPID)
        .collect(Collectors.toList());
    String PID = student.getPID();
    if (PIDList.contains(PID)) {
      for (int i = 0; i < students.size(); i++) {
        if (students.get(i).equals(student)) {
          students.set(i, student);
          database.updateDb(students);
          return true;
        }
      }
    } else {
      return false;
    }
    return false;
  }

  @Override
  public List<Student> getAllStudent() {
    return (List<Student>) database.loadDb();
  }

  @Override
  public IDatabase getDatabase() {
    return database;
  }

  @Override
  public void setDatabase(IDatabase database) {
    this.database = database;
  }
}
