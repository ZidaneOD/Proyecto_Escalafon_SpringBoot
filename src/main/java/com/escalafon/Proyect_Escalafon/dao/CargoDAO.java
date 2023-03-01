package com.escalafon.Proyect_Escalafon.dao;

import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import com.escalafon.Proyect_Escalafon.models.Login.Usuario;

import java.util.List;
import java.util.Optional;

public interface CargoDAO {
    List<Cargo> getCargos();
    void deleteCargo(int idCargo);
    void insertCargo(Cargo cargo);
    void updateCargo(Cargo cargo);
    Cargo obtenerPorId(int id);


}
