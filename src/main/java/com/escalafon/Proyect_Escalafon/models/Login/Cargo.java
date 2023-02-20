package com.escalafon.Proyect_Escalafon.models.Login;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cargo")
@ToString

public class Cargo {
    @Getter @Setter
    @Column(name = "idcargo") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCargo;
    @Getter @Setter
    @Column(name = "tipocargo")
    private String tipoCargo;
    @Getter @Setter
    @Column(name = "estado")
    private int estado;
}
