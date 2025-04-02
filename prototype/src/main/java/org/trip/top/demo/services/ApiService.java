package org.trip.top.demo.services;

import org.springframework.stereotype.Service;
import org.trip.top.demo.bouwsteen.Bouwsteen;

import java.util.List;

@Service
public interface ApiService {
    List<Bouwsteen> getBouwstenen(String locatie);
}
