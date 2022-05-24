package com.example.musique.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.musique.entities.Musique;
import com.example.musique.entities.Style;
import com.example.musique.service.StyleService;
import com.example.musique.service.MusiqueService;
@Controller
public class MusiqueController {
@Autowired
MusiqueService musiqueService;
@Autowired
StyleService StyleService;
@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
List<Style> cats = StyleService.findAll();
modelMap.addAttribute("styles", cats);
modelMap.addAttribute("musique", new Musique());
modelMap.addAttribute("mode", "new");
return "formMusique";
}

@RequestMapping("/saveMusique")
public String saveMusique(ModelMap modelMap,@Valid Musique musique,
BindingResult bindingResult)
{
	List<Style> cats = StyleService.findAll();
	modelMap.addAttribute("styles", cats);
System.out.println(musique);
if (bindingResult.hasErrors()) return "formMusique";
musiqueService.saveMusique(musique);
return "redirect:/listeMusique";
}

@RequestMapping("/showCreateStyle")
public String showCreateStyle(ModelMap modelMap)
{
modelMap.addAttribute("styles", new Style());
modelMap.addAttribute("mode", "new");
return "formStyle";
}
@RequestMapping("/saveStyle")
public String saveStyle(@ModelAttribute("style") Style style,ModelMap modelMap) throws ParseException 
{
Style saveStyle= StyleService.saveStyle(style);
return "redirect:/listeStyle";
}

@RequestMapping("/listeStyle")
public String listeMusique(ModelMap modelMap)
{
List <Style> cats = StyleService.findAll();
modelMap.addAttribute("styles", cats);
return "listeStyle";
}

@RequestMapping("/listeMusique")
public String listeMusique(ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
Page<Musique> musique = musiqueService.getAllMusiquesParPage(page, size);
modelMap.addAttribute("musiques", musique);
 modelMap.addAttribute("pages", new int[musique.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
return "listeMusique";
}


@RequestMapping("/supprimerMusique")
public String supprimerMusique(@RequestParam("id") Long id,
ModelMap modelMap,
@RequestParam (name="page",defaultValue = "0") int page,
@RequestParam (name="size", defaultValue = "3") int size)
{
musiqueService.deleteMusiqueById(id);
Page<Musique> musique = musiqueService.getAllMusiquesParPage(page,size);
modelMap.addAttribute("musiques", musique);
modelMap.addAttribute("pages", new int[musique.getTotalPages()]);
modelMap.addAttribute("currentPage", page);
modelMap.addAttribute("size", size);
return "listeMusique";
}
@RequestMapping("/supprimerStyle")
public String supprimerStyle(@RequestParam("id") Long id,
 ModelMap modelMap)
{ 
StyleService.deleteStyleById(id);
List<Style> cats = StyleService.findAll();
modelMap.addAttribute("styles", cats);
return "ListeStyle";
}

@RequestMapping("/modifierMusique")
public String editerMusique(@RequestParam("id") Long id,ModelMap modelMap)
{
	Musique p= musiqueService.getMusique(id);
	List<Style> cats = StyleService.findAll();
	cats.remove(p.getStyle());
	modelMap.addAttribute("styles", cats);
	modelMap.addAttribute("musique", p);
	modelMap.addAttribute("mode", "edit");
	return "formMusique";

}
@RequestMapping("/updateMusique")
public String updateMusique(@ModelAttribute("musique") Musique musique,
@RequestParam("date") String date,ModelMap modelMap) throws ParseException {
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 musique.setDateCreation(dateCreation);
	 
	 musiqueService.updateMusique(musique);
	 List<Musique> m = musiqueService.getAllMusiques();
	 modelMap.addAttribute("musiques", m);
	return "listeMusique";
	}
@RequestMapping("/modifierStyle")
public String editerStyle(@RequestParam("id") Long id,ModelMap modelMap)
{
Style s= StyleService.getStyle(id);
modelMap.addAttribute("styles", s);
modelMap.addAttribute("mode", "edit");
return "formStyle";
}
@RequestMapping("/updateStyle")
public String updateStyle(@ModelAttribute("style") Style style,ModelMap modelMap) throws ParseException {
	StyleService.updateStyle(style);
	 List<Style> st = StyleService.findAll();
	 modelMap.addAttribute("styles", st);
	return "listeStyle";
	}

@RequestMapping("/rechercher")
public String rechercher(@RequestParam("nom") String nom,
ModelMap modelMap)
{
	List<Style> cats = StyleService.findAll();
	modelMap.addAttribute("styles", cats);
List<Musique> prods = musiqueService.findByNomMusique(nom);
modelMap.addAttribute("musiques",prods);
return "listeMusique";
}
}