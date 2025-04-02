package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public class Betaald implements BouwsteenStatus {
    @Override
    public Bouwsteen voerUit(Bouwsteen bouwsteen) {
        var statusUpdate = "Bouwsteen wordt uitgevoerd";
        System.out.println(statusUpdate);
        bouwsteen.setStatus(new Uitgevoerd());
        return null;
    }
}
