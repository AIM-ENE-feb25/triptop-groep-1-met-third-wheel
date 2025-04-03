package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

public class Betaald implements BouwsteenStatus {
    @Override
    public void voerUit(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new Uitgevoerd());
    }
}
