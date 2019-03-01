package lambda;

public class Member {

    private String name;
    private  String id;
    private Address address;

    public Member(String id) {
        this.id = id;
    }

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Member(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", address=" + address +
                '}';
    }
}
