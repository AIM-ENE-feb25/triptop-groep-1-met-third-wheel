# vragen
1. het probleem is dat je wil dat bepaalde acties alleen worden toegestaan als de bouwstenen zich in een bepaalde toestand bevinden
2. er is een behavioral pattern nodig want hij moet zijn gedrag kunnen veranderen op basis van de toestand waarin hij zig bevindt

```java
interface DobbelsteenState {
    int getScore(int aantalOgen);
    DobbelsteenState volgendeBijEven();
    DobbelsteenState volgendeBijOneven();
}

class Enkel implements DobbelsteenState {
    @Override
    public int getScore(int aantalOgen) {
        return aantalOgen;
    }

    @Override
    public DobbelsteenState volgendeBijEven() {
        return new Dubbel();
    }

    @Override
    public DobbelsteenState volgendeBijOneven() {
        return this;
    }
}

class Dubbel implements DobbelsteenState {
    @Override
    public int getScore(int aantalOgen) {
        return 2 * aantalOgen;
    }

    @Override
    public DobbelsteenState volgendeBijEven() {
        return new Kwadraat();
    }

    @Override
    public DobbelsteenState volgendeBijOneven() {
        return new Enkel();
    }
}

class Kwadraat implements DobbelsteenState {
    @Override
    public int getScore(int aantalOgen) {
        return aantalOgen * aantalOgen;
    }

    @Override
    public DobbelsteenState volgendeBijEven() {
        return this;
    }

    @Override
    public DobbelsteenState volgendeBijOneven() {
        return new Dubbel();
    }
}

class Dobbelsteen {
    private int aantalOgen;
    private DobbelsteenState huidigeState;

    public Dobbelsteen() {
        this.huidigeState = new Enkel(); // Start in toestand Enkel
    }

    public int werp() {
        aantalOgen = (int) (Math.random() * 6) + 1; // Genereer een worp (1-6)
        int score = huidigeState.getScore(aantalOgen);
        volgende();
        return score;
    }

    public void volgende() {
        if (aantalOgen % 2 == 0) {
            huidigeState = huidigeState.volgendeBijEven();
        } else {
            huidigeState = huidigeState.volgendeBijOneven();
        }
    }
}

public class DobbelspelTest {
    public static void main(String[] args) {
        Dobbelsteen dobbelsteen = new Dobbelsteen();
        int totaleScore = 0;

        for (int i = 1; i <= 10; i++) {
            int score = dobbelsteen.werp();
            totaleScore += score;
            System.out.println("Worp " + i + ": Score = " + score);
        }

        System.out.println("Totale score na 10 worpen: " + totaleScore);
    }
}
```