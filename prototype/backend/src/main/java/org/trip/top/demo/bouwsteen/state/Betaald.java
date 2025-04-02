package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public class Betaald implements BouwsteenStatus {
    @Override
    public void voerUit(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new Uitgevoerd());
    }
}
