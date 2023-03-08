package com.dam.springboot.app.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.dam.springboot.app.models.dao.IArmaDao;
import com.dam.springboot.app.models.entity.Arma;


@Controller
@SessionAttributes("arma")
public class ArmaController {
	@Autowired
	private IArmaDao armaDao;	
	
	@GetMapping(value = "/")
	public String inicio(Model model) {
		model.addAttribute("titulo", "Armitas");
		model.addAttribute("armas", armaDao.findAll());
		return "home";
	}
	
	@GetMapping(value = "/armas")
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de armas");
		model.addAttribute("armas", armaDao.findAll());
		return "listar";
	}
	
	@GetMapping(value = "/armas/crear")
	public String crear(Map<String, Object> model) {
		model.put("titulo", "Insertar un Arma");
		model.put("arma", new Arma());
		return "form";
	}
	
	@PostMapping(value = "/armas/guardar")
	public String guardarArma(@Valid Arma arma, BindingResult result, Model model, SessionStatus status, @RequestParam("file") MultipartFile imagen) {
		if(!imagen.isEmpty()) {
			Path directorioImagen = Paths.get("src//main//resources//static//img");
			String rutaAbsoluta = directorioImagen.toFile().getAbsolutePath();
			String nombreImagen = arma.getNombre_Arma() + "-" + arma.getNombre_Skin() + ".png";
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + nombreImagen);
				if(!Files.exists(rutaCompleta)) {
			        Files.write(rutaCompleta, bytesImg);
			    }
				
				arma.setImagen(nombreImagen);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		status.setComplete();
		armaDao.save(arma);
		return "redirect:/armas";
	}
	
	@GetMapping(value="/armas/editar/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Arma arma = null;
		
		if(id > 0) {
			arma = armaDao.findOne(id);
		} else {
			return "redirect:/armas";
		}
		model.put("arma", arma);
		model.put("titulo", "Editar datos del arma");
		return "form_edit";
	}
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			armaDao.delete(id);
		}
		return "redirect:/armas";
	}
	
	@GetMapping("/armas/detalles/{id}")
	public String mostrarDetalleArma(@PathVariable Long id, Model model) {
	    Optional<Arma> arma = Optional.of(armaDao.findOne(id));
	    if (arma.isPresent()) {
	        model.addAttribute("arma", arma.get());
	        return "detalles";
	    } else {
	        return "redirect:/armas";
	    }
	}
	
	
	
	
}
