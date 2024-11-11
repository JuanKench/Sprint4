public class Protocol {
    final int INITIAL = 0;
    final int INTHELOOP = 1;

    dataBas d = new dataBas();

    protected int state = INITIAL;

    public String getOutput(String fromClient){
        if (state == INITIAL){
            state = INTHELOOP;
            return "hej och hå";

        }
        else if (state == INTHELOOP){
            return d.search(fromClient);
        }
        return "nope didnt happen";
    }
}
