package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class CargoDAOImp implements CargoDAO{
    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<Cargo> getCargos() {
        String query = "FROM Cargo WHERE estado=1";
        return entityManager.createQuery(query).getResultList();

    }
    @Override
    public void deleteCargo(int idCargo) {

        Cargo selectcargo = entityManager.find(Cargo.class, idCargo);
        selectcargo.setEstado(0);
        entityManager.merge(selectcargo);
    }

    @Override
    public void insertCargo(Cargo cargo) {
        cargo.setEstado(1);
        entityManager.merge(cargo);
    }

    @Override
    public void updateCargo(Cargo cargo) {
       // Cargo selectcargo = entityManager.find(Cargo.class, cargo.getIdCargo());
       // selectcargo.setTipoCargo(cargo.getTipoCargo());
        cargo.setEstado(1);
        entityManager.merge(cargo);
    }

    @Override
    public Cargo obtenerPorId(int idCargo) {

       Cargo cargo= entityManager.find(Cargo.class,idCargo);
        return cargo;
    }



}
