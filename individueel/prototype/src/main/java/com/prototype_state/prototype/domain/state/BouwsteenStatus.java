package com.prototype_state.prototype.domain.state;


import com.prototype_state.prototype.domain.Bouwsteen;

public interface BouwsteenStatus {
    default void pasAan(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet aangepast worden", getStatusName()));
    }

    default void regel(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet geregeld worden", getStatusName()));
    }

    default void betaal(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet betaald worden", getStatusName()));
    }

    default void voerUit(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet uitgevoerd worden", getStatusName()));
    }

    default void annuleer(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet geannuleerd worden.", getStatusName()));
    }

    default String getStatusName() {
        return this.getClass().getSimpleName();
    }
}
