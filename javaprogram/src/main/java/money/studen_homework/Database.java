package money.studen_homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Database implements IDatabase {

  private long lastModifed;

  @Override
  public Object loadDb() {

    List<Student> students = new ArrayList<>();
    FileInputStream inputStream = null;
    try {
      inputStream = new FileInputStream("database.db");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    try {
      String str = null;
      while ((str = bufferedReader.readLine()) != null) {
        students.add(parseStudentFromString(str));
      }
      //close
      inputStream.close();
      bufferedReader.close();
      return students;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return students;
  }

  @Override
  public void updateDb(Object studList) {
    List<Student> students = (List<Student>) studList;
    File fout = new File("database.db");
    FileWriter fw = null;
    try {

      fw = new FileWriter(fout);
      for (int i = 0; i < students.size(); i++) {
        fw.write(students.get(i).toString());
        fw.write("\n");
      }
      fw.flush();
      fw.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  /**
   * parse a student from file
   */
  private Student parseStudentFromString(String s) {
    String[] fields = s.split("\\|");
    Student student = new Student();
    student.setName(fields[0].split(":")[1]);
    student.setPID(fields[1].split(":")[1]);
    student.setMajor(fields[2].split(":")[1]);
    student.setMinor(fields[3].split(":")[1]);
    String fen = fields[4].split(":")[1];
    if (null != fen ) {
      student.setCGPA(Double.parseDouble(fen));
    }
    student.setCollege(fields[5].split(":")[1]);
    student.setEmail(fields[6].split(":")[1]);
    return student;
  }
}
