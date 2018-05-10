
public class httprequest {
	public String method;
	public String host;
	public String accept;
	public String connection;

	public httprequest(String method, String host, String accept, String connection) {
		this.method = method;
		this.host = host;
		this.accept = accept;
		this.connection = connection;
	}
}
