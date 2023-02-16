package com.escalafon.Proyect_Escalafon.cotrollers;

import com.escalafon.Proyect_Escalafon.dao.CargoDAO;
import com.escalafon.Proyect_Escalafon.dao.CargoDAOImp;
import com.escalafon.Proyect_Escalafon.models.Login.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CargoController {
    @Autowired
    private CargoDAO cargoDAO;

    @RequestMapping(value = "putUsuario")
    public Cargo putUsuario() {
        Cargo usu = new Cargo();
        usu.setIdCargo(1);
        usu.setTipoCargo("Ortiz Diaz");
        usu.setEstado(1);
        return usu;
    }


    @RequestMapping(value = "api/postCargo", method = RequestMethod.POST)//Ingresar Usuario
    public void postCargo(@RequestBody Cargo cargo){

        cargoDAO.insertCargo(cargo);
    }

    @RequestMapping(value = "api/deleteCargo",method = RequestMethod.DELETE)//Eliminar Usuario
    public void deleteCargo(@RequestHeader(value = "Authorization")@PathVariable int   idCargo){

        cargoDAO.deleteCargo(idCargo);
    }

    @RequestMapping(value = "api/listCargo", method = RequestMethod.GET)
    public List<Cargo> listCargo() {

        return cargoDAO.getCargos();
    }
}
