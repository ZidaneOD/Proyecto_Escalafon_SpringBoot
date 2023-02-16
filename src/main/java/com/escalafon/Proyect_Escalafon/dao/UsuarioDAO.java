package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Usuario;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> getUsuarios();
    void deleteUsuario(String idUsuario);
    void insertUsuario(Usuario usuario);
    void updateUsuario(String idUsuario,Usuario usuario);
    boolean validadLogin(Usuario usuario);
}
