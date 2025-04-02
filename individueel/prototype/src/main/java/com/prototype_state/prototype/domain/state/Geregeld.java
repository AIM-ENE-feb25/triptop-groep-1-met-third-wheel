package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

public class Geregeld implements BouwsteenStatus {
    @Override
    public Bouwsteen betaal(Bouwsteen bouwsteen) {
        var statusUpdate = "Bouwsteen wordt betaald";
        System.out.println(statusUpdate);
        bouwsteen.setStatus(new Betaald());
        return null;
    }

    @Override
    public Bouwsteen annuleer(Bouwsteen bouwsteen) {
        var statusUpdate = "Bouwsteen wordt geannuleerd";
        System.out.println(statusUpdate);
        bouwsteen.setStatus(new NietUitvoerbaar("is geannuleerd"));
        return null;
    }
}
