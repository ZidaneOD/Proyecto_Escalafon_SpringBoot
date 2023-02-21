package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
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
        StoredProcedureQuery sp= entityManager.createStoredProcedureQuery("sp_listar_cargo");
        sp.execute();
        return  sp.getResultList(); //RETORNA EL LISTADO

    }

    @Override
    @Transactional
    public List<Cargo> getList() {
       String query= "FROM Cargo";
       return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void deleteCargo(int idCargo) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("sp_delete_cargo")
                .registerStoredProcedureParameter("idCargo", Integer.class, ParameterMode.IN)//registra el parámetro
                .setParameter("idCargo", idCargo);//se ingresa el dato
        sp.execute();//se ejecuta


        /*Cargo cargo = entityManager.find(Cargo.class, idCargo);
        entityManager.remove(cargo);*/
    }

    @Override
    public void insertCargo(Cargo cargo) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("sp_insert_cargo")
                .registerStoredProcedureParameter("tipoCargo", String.class, ParameterMode.IN)//registra el parámetro
                .setParameter("tipoCargo", cargo.getTipoCargo());//se ingresa el dato
        sp.execute();//se ejecuta
        //entityManager.merge(cargo);
    }

    @Override
    public void updateCargo(int idCargo, Cargo cargo) {
        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("sp_update_cargo")
                .registerStoredProcedureParameter("idCargo", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("tipoCargo", String.class, ParameterMode.IN)
                .setParameter("idCargo",idCargo)
                .setParameter("tipoCargo", cargo.getTipoCargo());
        sp.execute();


        /*
        Cargo selectcargo = entityManager.find(Cargo.class, idCargo);
        selectcargo.setTipoCargo(cargo.getTipoCargo());
        entityManager.merge(selectcargo);*/
    }




}
