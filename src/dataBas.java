import java.util.List;

public class dataBas {
    TelefonBok person1 = new TelefonBok("123", "Johan", "det du", "1532456");
    TelefonBok person2 = new TelefonBok("254", "mig", "det", "1532456");
    TelefonBok person3 = new TelefonBok("265", "that guy", " du", "1532456");
    TelefonBok person4 = new TelefonBok("777", "cool", "dedu", "1532456");
    TelefonBok person5 = new TelefonBok("007", "dude", "detdu", "1532456");

    List<TelefonBok> data = List.of(person1, person2, person3, person4, person5);

    public dataBas(){

    }
    public TelefonBok search(String nummer) // hur gör jag så att den söker efter mer än bara nummer? (på ett snyggt sätt)
    {
        for (TelefonBok t : data) {
            if (t.getNummer().equals(nummer)) {
                return t;
            }
        }
        return null;
    }
    public String allData(TelefonBok person) {
        return person.nummer+" "+person.namn+" "+person.address+" "+person.id;
    }

}
