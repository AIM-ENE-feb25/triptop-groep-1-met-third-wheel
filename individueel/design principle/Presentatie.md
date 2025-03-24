# Dependency Inversion Principle (DIP)
Klasses moeten niet afhankelijk zijn van concrete klassen, maar van abstracte klasses of interface
Constructor of setter dependency gebruiken.

Andere naam: Prefer Interfaces to classes  
Design property: coupling
# Voorbeelden
Voorbeeld hexagonale structuur van doex
## Zonder DIP
```java
@Service
public class EnsembleService {

    private final EnsembleRepository ensembleRepository;
    private final NotifierService notifierService;

    public EnsembleService() {
        this.ensembleRepository = new EnsembleRepository(); 
        this.notifierService = new NotifierService(); 
    }

    public void joinAsParticipant(Ensemble ensemble, Member member) {
        ensemble.joinAsParticipant(AggregateReference.to(member.getId()));
        ensembleRepository.save(ensemble);
        notifierService.memberAccepted(ensemble, member);
    }
}
```

## Met DIP
```Java

public interface EnsembleServicePort{
    void joinAsParticipant(Ensemble ensemble, Member member);
}

public interface EnsembleRepository extends CrudRepository<Ensemble, Integer> {
    Optional<Ensemble> findByName(String name);
}

@Service
public class EnsembleService implements EnsembleServicePort {

    private final EnsembleRepository ensembleRepository;
    private final NotifierService notifierService;

    public EnsembleService(EnsembleRepository ensembleRepository,
                           NotifierService notifierService) {
        this.ensembleRepository = ensembleRepository;
        this.notifierService = notifierService;

    }

    @Override
    public void joinAsParticipant(Ensemble ensemble, Member member) {
        ensemble.joinAsParticipant(AggregateReference.to(member.getId()));
        ensembleRepository.save(ensemble);
        notifierService.memberAccepted(ensemble, member);

    }
}
```