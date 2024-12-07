package pe.edu.cibertec.DAAI_T2_PantaJefferson.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private Date fechgraduacion;
    @ManyToOne
    @JoinColumn(name = "Idmedico")
    private Medico medico;
}
