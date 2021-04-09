package com.kuliah.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.services.ModelDosen;
import com.kuliah.main.services.ModelMahasiswa;
import com.kuliah.main.services.ModelMataKuliah;
import com.kuliah.main.services.ModelPlotMataKuliah;
import com.kuliah.main.services.ModelSoal;

@Controller
public class PlotMataKuliahPage {

	
	@Autowired
	ModelPlotMataKuliah modelPlotMataKuliah;
	
	@Autowired
	ModelMahasiswa modelMahasiswa;
	
	@Autowired
	ModelDosen modelDosen;
	
	@Autowired
	ModelSoal modelSoal;
	
	@Autowired
	ModelMataKuliah modelMataKuliah;
	
	@GetMapping("/plotmatakuliah/view")
	public String viewPoltMataKuliah(Model model) {
		
		model.addAttribute("ListPlotMataKuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen",modelDosen.getAllDosen());
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		model.addAttribute("active",6);
		return "view_plotmatakuliah";
	}
	
	@GetMapping("/plotmatakuliah/add")
	public String viewAddPlotMatakuliah(Model model) {
		
		model.addAttribute("plotmatakuliah", new PlotMataKuliah());
		model.addAttribute("listMahasiswa", modelMahasiswa.getAllMahasiswa());
		model.addAttribute("listDosen",modelDosen.getAllDosen());
		model.addAttribute("listSoal",modelSoal.getAllSoal());
		model.addAttribute("listMataKuliah",modelMataKuliah.getAllMataKuliah());
		return "add_plotmatakuliah";
	}
	

	@PostMapping("/plotmatakuliah/view")
	  public String addPlotMataKuliah(@ModelAttribute PlotMataKuliah plotMataKuliah, Model model) {
		
		// buat penampung data MataKuliah di halaman htmlnya
		this.modelPlotMataKuliah.addPlotMataKuliah(plotMataKuliah);
		model.addAttribute("listPlotMataKuliah",modelPlotMataKuliah.getAllPlotMataKuliah());
		
		
		return "redirect:/plotmatakuliah/view";
	}
	@GetMapping("/plotmatakuliah/update/{id}")
	public String viewUpdatePlotMataKuliah(@PathVariable String id, Model model) {
		
		PlotMataKuliah plotMataKuliah = modelPlotMataKuliah.getPlotMataKuliahById(id);
		
		model.addAttribute("plotmatakuliah",plotMataKuliah);
		
		return "add_plotmatakuliah";
	}
	
	@GetMapping("/plotmatakuliah/delete/{id}")
	public String deletePlotMataKuliah(@PathVariable String id, Model model) {
		
		this.modelPlotMataKuliah.deletePlotMataKuliang(id);
		model.addAttribute("listSoal",modelPlotMataKuliah.getAllPlotMataKuliah());
		
		
		return "redirect:/plotmatakuliah/view";
	}

}
