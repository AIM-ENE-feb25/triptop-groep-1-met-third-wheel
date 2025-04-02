package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

public class NietUitvoerbaar implements BouwsteenStatus {
    private final String reden;

    public NietUitvoerbaar(String reden) {
        this.reden = reden;
    }

    @Override
    public void voerUit(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen is niet uitvoerbaar vanwege: %s", reden));
    }
}
