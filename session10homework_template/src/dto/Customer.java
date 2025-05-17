package dto;

public class Customer {
    public String id;
    public String password;
    public Rank rank;

    public Customer(String id, String password, Rank rank) {
        this.id = id;
        this.password = password;
        this.rank = rank;
    }
}
