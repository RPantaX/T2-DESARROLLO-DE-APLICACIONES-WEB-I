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
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    private Date fechancmedico;
}
