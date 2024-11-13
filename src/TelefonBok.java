public class TelefonBok {
    protected String nummer;
    protected String namn;
    protected String address;
    protected String id;

    public TelefonBok(String nummer, String namn, String address, String id) {
        this.nummer = nummer;
        this.namn = namn;
        this.address = address;
        this.id = id;
    }

    public String getNummer() {
        return nummer;
    }

    public String getNamn() {
        return namn;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }
}
