package money.studen_homework;

import java.util.List;

public class StudentResponseObj extends BaseResponse implements IResponse {

  private Student content;
  private List<Student> listContent;

  @Override
  public Object getContent() {
    return content;
  }

  @Override
  public void setContent(Object content) {
    this.content = (Student) content;

  }

  @Override
  public Object getListContent() {
    return listContent;
  }

  @Override
  public void setListContent(Object content) {
    this.listContent = (List<Student>) content;
  }
}
