package money.studen_homework;

public interface IResponse {
	
	public Integer getResponseCode();
	public void setResponseCode(Integer responseCode);
	public String getResponseString();
	public void setResponseString(String responseString);
	public Object getContent();
	public void setContent(Object content);
	public Object getListContent();
	public void setListContent(Object content);
	
}
