package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public class Geregeld implements BouwsteenStatus {
    @Override
    public void betaal(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new Betaald());
    }

    @Override
    public void annuleer(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new NietUitvoerbaar("is geannuleerd"));
    }
}
