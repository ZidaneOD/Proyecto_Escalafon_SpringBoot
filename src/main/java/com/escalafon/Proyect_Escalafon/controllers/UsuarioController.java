package com.escalafon.Proyect_Escalafon.controllers;

import com.escalafon.Proyect_Escalafon.dao.UsuarioDAO;
import com.escalafon.Proyect_Escalafon.models.Login.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping(value = "api/postUsuario", method = RequestMethod.POST)//Ingresar Usuario
    public void postUser(@RequestBody Usuario usuario){

        usuarioDAO.insertUsuario(usuario);
    }

    @RequestMapping(value = "api/deleteUsuario",method = RequestMethod.DELETE)//Eliminar Usuario
    public void deleteUser(@RequestHeader(value = "Authorization")@PathVariable String   idUsuario){

        usuarioDAO.deleteUsuario(idUsuario);
    }
    @RequestMapping(value = "api/modificarUsuario/{id}",method = RequestMethod.PUT)//Editar usuario
    public void updateUsuario(@RequestHeader(value = "Authorization")@PathVariable String idUsuario , @PathVariable Usuario usuario){//Falta el metodo modificar

        usuarioDAO.updateUsuario(idUsuario,usuario);

        }
    }



