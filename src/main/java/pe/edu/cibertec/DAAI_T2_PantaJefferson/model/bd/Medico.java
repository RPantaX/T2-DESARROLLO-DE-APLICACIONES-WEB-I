package pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Medico")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMedico")
    private Integer idMedico;
    @Column(name = "NomMedico")
    private String nomMedico;
    @Column(name = "ApeMedico")
    private String apeMedico;
    @Column(name = "FechNacMedico")
    private Date fechaNacMedico;
}
