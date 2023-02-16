package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImp implements UsuarioDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteUsuario(String idUsuario) {
        Usuario usuario = entityManager.find(Usuario.class, idUsuario);
        entityManager.remove(usuario);
    }

    @Override
    public void insertUsuario(Usuario usuario) {

        entityManager.merge(usuario);
    }

    @Override
    public void updateUsuario( String idUsuario, Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean validadLogin(Usuario usuario) {
        return false;
    }
}
