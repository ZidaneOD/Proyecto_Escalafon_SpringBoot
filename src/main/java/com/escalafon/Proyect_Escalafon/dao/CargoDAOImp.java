package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import com.escalafon.Proyect_Escalafon.models.Login.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CargoDAOImp implements CargoDAO{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<Cargo> getCargos() {
        String query = "FROM Cargo";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteCargo(int idCargo) {
        Cargo cargo = entityManager.find(Cargo.class, idCargo);
        entityManager.remove(cargo);
    }

    @Override
    public void insertCargo(Cargo cargo) {
        entityManager.merge(cargo);
    }

    @Override
    public void updateCargo(int idCargo, Cargo cargo) {

    }
}
