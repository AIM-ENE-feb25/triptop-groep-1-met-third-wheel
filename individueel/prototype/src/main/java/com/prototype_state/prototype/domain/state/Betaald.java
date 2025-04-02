package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

public class Betaald implements BouwsteenStatus {
    @Override
    public Bouwsteen voerUit(Bouwsteen bouwsteen) {
        var statusUpdate = "Bouwsteen wordt uitgevoerd";
        System.out.println(statusUpdate);
        bouwsteen.setStatus(new Uitgevoerd());
        return null;
    }
}
