package money.studen_homework;

public interface IController {

	IService getService();
	void setService(IService service);
	IResponse getResponse();
	void setResponse(IResponse response);

	IResponse getStudent(Student student);
	IResponse addStudent(Student student);
	IResponse removeStudent(Student student);
	IResponse updateStudent(Student student);
	IResponse getAllStudent();

}