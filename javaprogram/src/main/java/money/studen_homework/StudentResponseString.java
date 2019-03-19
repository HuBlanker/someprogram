package money.studen_homework;

public class StudentResponseString extends BaseResponse implements IResponse {

  private String content;
  private String listContent;

  @Override
  public Object getContent() {
    return content;
  }

  @Override
  public void setContent(Object content) {
    this.content = (String) content;
  }

  @Override
  public Object getListContent() {
    return listContent;
  }

  @Override
  public void setListContent(Object content) {
    this.listContent = (String) content;
  }
}
