package money.studen_homework;

import java.util.List;

public interface IService {
	
	public void loadDb();
	public void updateDb();
	public Student getStudent(Student student);
	public boolean addStudent(Student student);
	public boolean removeStudent(Student student);
	public boolean updateStudent(Student student);
	public List<Student> getAllStudent();
	
	public IDatabase getDatabase();
	public void setDatabase(IDatabase database);

}
