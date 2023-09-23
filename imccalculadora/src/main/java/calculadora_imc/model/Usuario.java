package calculadora_imc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Integer id = 0;
    public Integer getId() { return id; }
    public double peso;
    public double altura; 
    public String resultado;
}


