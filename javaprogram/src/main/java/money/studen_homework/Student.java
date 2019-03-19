package money.studen_homework;

/*
 * Provide a default constructor, a parameterized constructor, getters and setters.
 * Fill implementation of toString, hashCode and equals.
 */
public class Student {

  String name;
  String PID;
  String major;
  String minor;
  Double CGPA;
  String college;
  String email;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPID() {
    return PID;
  }

  public void setPID(String PID) {
    this.PID = PID;
  }

  public String getMajor() {
    return major;
  }

  public void setMajor(String major) {
    this.major = major;
  }

  public String getMinor() {
    return minor;
  }

  public void setMinor(String minor) {
    this.minor = minor;
  }

  public Double getCGPA() {
    return CGPA;
  }

  public void setCGPA(Double CGPA) {
    this.CGPA = CGPA;
  }

  public String getCollege() {
    return college;
  }

  public void setCollege(String college) {
    this.college = college;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "name:" + name + "|" + "PID:" + PID + "|" + "major:" + major + "|" + "minor:" + minor
        + "|" + "CGPA:" + String.format("%f", CGPA) + "|" + "college:" + college + "|" + "email:"
        + email;
  }

  @Override
  public int hashCode() {
    return PID.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Student student = (Student) obj;
    return this.PID.equals(student.PID);
  }
}
