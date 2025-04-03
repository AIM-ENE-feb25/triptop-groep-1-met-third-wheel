package com.prototype_state.prototype.domain.state;

import com.prototype_state.prototype.domain.Bouwsteen;

public class Gepland implements BouwsteenStatus {

    @Override
    public void pasAan(Bouwsteen aangepasteBouwsteen) {
    }

    @Override
    public void regel(Bouwsteen bouwsteen) {
        bouwsteen.setStatus(new Geregeld());
    }
}
