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
    @Column(name = "idusuario") @Id
    private String idUsuario;

    @Getter @Setter
    @Column(name = "apellidopat")
    private String apellidoPat;

    @Getter @Setter
    @Column(name = "apellidomat")
    private String apellidoMat;

    @Getter @Setter
    @Column(name = "nombres")
    private String nombres;

    @Getter @Setter
    @Column(name = "fechnaci")
    private Date fechNaci;

    @Getter @Setter
    @Column(name = "correo")
    private String correo;

    @Getter @Setter
    @Column(name = "logiusua")
    private String logiUsua;

    @Getter @Setter
    @Column(name = "password")
    private String password;

    @Getter @Setter
    @Column(name = "idcargo")
    private Long idCargo;

    @Getter @Setter
    @Column(name = "estado")
    private int estado;

}
