package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

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
