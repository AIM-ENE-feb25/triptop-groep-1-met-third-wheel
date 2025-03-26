Student klasse die in beide voorbeelden wordt gebruikt
```java
public class Student {
    private String naam;
    
    public Student(String naam) {
        this.naam = naam;
    }
    
    public String getNaam() {
        return naam;
    }
}
```

Fout voorbeeld, want er wordt een methode aangeroepen in Docent die Docent zelf niet direct kan aanroepen.
```java
public class Klas {
    private List<Student> studenten = new ArrayList<>();
    
    public void voegStudentToe(Student student) {
        studenten.add(student);
    }
    
    public List<Student> getStudenten() {
        return studenten;
    }
}

public class Docent {
    private Klas klas;
    
    public Docent(Klas klas) {
        this.klas = klas;
    }
    
    public Klas getKlas() {
        return klas;
    }

    // FOUT
    public void printStudentInformatie() {
        List<Student> studenten = klas.getStudenten();
        for(Student student : studenten) {
            System.out.println(student.getNaam());
        }
    }
}
```

Goed voorbeeld, want elke klasse roept alleen methodes aan waar die zelf direct bij kan.
```java
public class Klas {
  private List<Student> studenten = new ArrayList<>();

  public void voegStudentToe(Student student) {
    studenten.add(student);
  }

  public List<Student> getStudenten() {
    return studenten;
  }

  public void printStudentNamen() {
    for (Student student : studenten) {
      System.out.println(student.getNaam());
    }
  }
}

public class Docent {
  private Klas klas;

  public Docent(Klas klas) {
    this.klas = klas;
  }

  public Klas getKlas() {
    return klas;
  }

  // FOUT
  public void printStudentInformatie() {
    klas.printStudentNamen();
  }
}

```