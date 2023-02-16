package com.escalafon.Proyect_Escalafon.models.Login;


import lombok.Data;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Entity
@Table(name = "usuarios")
@ToString
@Data


public class Usuario {

    @Getter @Setter
    @Column(name = "idUsuario") @Id
    private String idUsuario;

    @Getter @Setter
    @Column(name = "apellidoPat")
    private String apellidoPat;

    @Getter @Setter
    @Column(name = "apellidoMat")
    private String apellidoMat;

    @Getter @Setter
    @Column(name = "nombres")
    private String nombres;

    @Getter @Setter
    @Column(name = "fechNaci")
    private Date fechNaci;

    @Getter @Setter
    @Column(name = "correo")
    private String correo;

    @Getter @Setter
    @Column(name = "logiUsua")
    private String logiUsua;

    @Getter @Setter
    @Column(name = "password")
    private String password;

    @Getter @Setter
    @Column(name = "idCargo")
    private Long idCargo;

    @Getter @Setter
    @Column(name = "estado")
    private int estado;

}
