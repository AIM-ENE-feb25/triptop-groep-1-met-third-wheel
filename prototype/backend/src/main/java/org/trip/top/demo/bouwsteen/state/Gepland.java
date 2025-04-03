package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public class Gepland implements BouwsteenStatus {

    @Override
    public void pasAan(Bouwsteen aangepasteBouwsteen) {
    }

    @Override
    public void regel(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new Geregeld());
    }
}
