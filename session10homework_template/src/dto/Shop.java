package dto;

public class Shop {
	private int id;
	public String name;
	public String dbPath; 
	
	public Shop() {
	}
	
	public Shop(int id, String name, String dbPath) {
		super();
		this.id = id;
		this.name = name;
		this.dbPath = dbPath; 
	} 
}
