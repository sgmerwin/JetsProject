package jets;

public class JetImpl extends Jet {

    public JetImpl() {
    }

    @Override
    public String toString() {
        return "JetImpl{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", speedMPH=" + speedMPH +
                ", rangeMiles=" + rangeMiles +
                ", price=" + price +
                '}';
    }
}

