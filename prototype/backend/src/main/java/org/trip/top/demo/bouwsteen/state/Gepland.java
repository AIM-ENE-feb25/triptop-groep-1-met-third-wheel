package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public class Gepland implements BouwsteenStatus {

    @Override
    public Bouwsteen pasAan(Bouwsteen aangepasteBouwsteen) {
        return aangepasteBouwsteen;
    }

    @Override
    public Bouwsteen regel(Bouwsteen bouwsteen) {
        var statusUpdate = "Bouwsteen wordt geregeld";
        System.out.println(statusUpdate);
        bouwsteen.setStatus(new Geregeld());
        return null;
    }
}
