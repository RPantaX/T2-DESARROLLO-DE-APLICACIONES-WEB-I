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
    @Column(name = "IdEspecialidad")
    private Integer idEspecialidad;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Funcion")
    private String funcion;
    @Column(name = "FechGraduacion")
    private Date fechGraduacion;
    @ManyToOne
    @JoinColumn(name = "IdMedico")
    private Medico medico;
}
