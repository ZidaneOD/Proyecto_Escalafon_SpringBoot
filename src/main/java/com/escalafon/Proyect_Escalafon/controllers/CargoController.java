package com.escalafon.Proyect_Escalafon.controllers;

import com.escalafon.Proyect_Escalafon.dao.CargoDAO;
import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import com.escalafon.Proyect_Escalafon.models.Login.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CargoController {
    @Autowired
    private CargoDAO cargoDAO;


    @RequestMapping(value = "api/postCargo", method = RequestMethod.POST)//Ingresar Usuario
    public void postCargo(@RequestBody Cargo cargo){

        cargoDAO.insertCargo(cargo);
    }

    @RequestMapping(value = "api/deleteCargo/{idCargo}",method = RequestMethod.DELETE)//Eliminar Usuario
    public void deleteCargo(@PathVariable int idCargo){

        cargoDAO.deleteCargo(idCargo);
    }

    @RequestMapping(value = "api/listCargo", method = RequestMethod.GET)
    public List<Cargo> listCargo() {

       return cargoDAO.getCargos();

    }
    @RequestMapping(value = "api/updateCargo/{idCargo}",method = RequestMethod.PUT)//Editar usuario
    public void updateCargo(@PathVariable int idCargo , @PathVariable Cargo cargo){

        cargoDAO.updateCargo(idCargo,cargo);

    }
}
