package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

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
