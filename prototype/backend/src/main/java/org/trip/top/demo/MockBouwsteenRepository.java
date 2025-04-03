package org.trip.top.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.bouwsteen.RestaurantBouwsteen;

@Repository
public class MockBouwsteenRepository {
  List<Bouwsteen> bouwstenen = new ArrayList<>();

  public MockBouwsteenRepository() {
    bouwstenen.add(
        new RestaurantBouwsteen(
            1, "Mandarijn", "mandarijn.com", "Mooie mandarijn", new Locatie("3.2", "4.3")));
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