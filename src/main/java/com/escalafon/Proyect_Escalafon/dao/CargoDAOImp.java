package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
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
    @Transactional
    public List<Cargo> getCargos() {
        String query = "FROM Cargo";
        try {
            return entityManager.createQuery(query).getResultList();

        }catch (Exception e){
            return null;
        }

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

        Cargo selectcargo = entityManager.find(Cargo.class, idCargo);
        selectcargo.setTipoCargo(cargo.getTipoCargo());
        entityManager.merge(selectcargo);
    }




}
