package org.trip.top.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.top.demo.bouwsteen.Bouwsteen;
import org.trip.top.demo.services.ApiService;
import org.trip.top.demo.services.KaartenService;
import org.trip.top.demo.services.RestaurantService;
import org.trip.top.demo.MockBouwsteenRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BouwsteenService {
    private final List<ApiService> apiServices;
    private final MockBouwsteenRepository mockBouwsteenRepository;

    @Autowired
    public BouwsteenService(List<ApiService> apiServices, MockBouwsteenRepository mockBouwsteenRepository) {
        this.apiServices = apiServices;
        this.mockBouwsteenRepository = mockBouwsteenRepository;
    }


    public List<Bouwsteen> getAlleRestaurantsOpLocatie(String locatie) {
        List<Bouwsteen> bouwstenen = new ArrayList<>();

        for (ApiService service : apiServices){
            if (service instanceof RestaurantService){
                bouwstenen.addAll(service.getBouwstenen(locatie));
            }
        }

        return bouwstenen;
    }

    public List<Bouwsteen> getRouteNaarBouwsteen(int id) {
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        List<Bouwsteen> bouwstenen = new ArrayList<>();

        for (ApiService service : apiServices){
            if (service instanceof KaartenService) {
                var adress = ((KaartenService) service).getAdress(bouwsteen.getLocatie());
                bouwstenen.addAll(service.getBouwstenen(adress));
            }
        }

        return bouwstenen;
    }

    public String planBouwsteen(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.plan();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String pasBouwsteenAan(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.pasAan();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String regelBouwsteen(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.regel();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String betaalBouwsteen(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.betaal();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String voerBouwsteenUit(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.voerUit();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String annuleerBouwsteen(int id){
        var bouwsteen = mockBouwsteenRepository.getBouwsteenById(id);
        bouwsteen.annuleer();
        mockBouwsteenRepository.saveBouwsteen(bouwsteen);
        return getStatus(id);
    }

    public String getStatus(int id) {
        if(mockBouwsteenRepository.getBouwsteenById(id).getStatus() == null) {
            return "Huidige status: " + mockBouwsteenRepository.getBouwsteenById(id).getStatus();
        }else{
            return "Huidige status: " + mockBouwsteenRepository.getBouwsteenById(id).getStatus().getStatusName();
        }
    }

}
