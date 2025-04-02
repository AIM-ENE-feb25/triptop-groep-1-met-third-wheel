package org.trip.top.demo.bouwsteen.state;


import org.trip.top.demo.bouwsteen.Bouwsteen;

public interface BouwsteenStatus {
    default Bouwsteen pasAan(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet aangepast worden", getStatusName()));
    }

    default Bouwsteen regel(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet geregeld worden", getStatusName()));
    }

    default Bouwsteen betaal(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet betaald worden", getStatusName()));
    }

    default Bouwsteen voerUit(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet uitgevoerd worden", getStatusName()));
    }

    default Bouwsteen annuleer(Bouwsteen bouwsteen) {
        throw new IllegalStateActionException(String.format("Bouwsteen met status %s mag niet geannuleerd worden.", getStatusName()));
    }

    default String getStatusName() {
        return this.getClass().getSimpleName();
    }
}
