package com.prototype_state.prototype;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import com.prototype_state.prototype.domain.Bouwsteen;
import java.util.List;

@Repository
public class MockRepository {
    List<Bouwsteen> bouwstenen = new ArrayList<>();

    public MockRepository() {
        bouwstenen.add(
                new Bouwsteen(
                        "Mandarijn", 1));
    }

    public Bouwsteen getBouwsteenById(int id) {
        return bouwstenen.stream()
                .filter(bouwsteen -> bouwsteen.getId() == id)
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public void saveBouwsteen(Bouwsteen bouwsteen) {
        bouwstenen.stream()
                .map(
                        bouwsteen1 -> {
                            if (bouwsteen1.getId() == bouwsteen.getId()) {
                                return bouwsteen;
                            }
                            return bouwsteen1;
                        });
    }
}
