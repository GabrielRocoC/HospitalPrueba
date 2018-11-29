/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entidades.Paciente;
import modelo.PacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gaberielroco
 */
@Controller
@RequestMapping("/mostrar.htm")
public class LeerExamen {
    @Autowired
    private PacienteDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String mostrarPaciente(){
        return "buscar";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String mostrarPaciente(
            @RequestParam("txtRut") String rut,
            Model model){
        
        if(rut.trim().equals("")){
            return "buscar";
        }
        
        Paciente p = dao.readByRutJPQL(rut);
        
        if(p == null){
            return "error";
        }
        
        model.addAttribute("listaExamen", p.getExamenesCollection());
        
        return "examenes";
    }
}

