package org.trip.top.demo.bouwsteen.state;

import org.trip.top.demo.bouwsteen.Bouwsteen;

public class NietUitvoerbaar implements BouwsteenStatus {
    private final String reden;

    public NietUitvoerbaar(String reden) {
        this.reden = reden;
    }

    @Override
    public Bouwsteen voerUit(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen is niet uitvoerbaar vanwege: %s", reden));
    }
}
