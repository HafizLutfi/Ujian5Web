package com.kuliah.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.kuliah.main.entity.PlotMataKuliah;
import com.kuliah.main.repository.PlotMataKuliahRepository;

@Service
public class ModelPlotMataKuliah implements ModelPlotMataKuliahInterface {

	@Autowired
	PlotMataKuliahRepository plotMataKuliahRespo;
	
	@Override
	public List<PlotMataKuliah> getAllPlotMataKuliah() {
		// TODO Auto-generated method stub
		
		return (List<PlotMataKuliah>) this.plotMataKuliahRespo.findAll();
	}

	@Override
	public PlotMataKuliah getPlotMataKuliahById(String id) {
		// TODO Auto-generated method stub
		return ((PlotMataKuliah)this.plotMataKuliahRespo.findByIdPlotMataKuliah(Long.parseLong(id)));
	}

	@Override
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotMataKuliah) {
		// TODO Auto-generated method stub
		return this.plotMataKuliahRespo.save(plotMataKuliah);
	}

	@Override
	public void deletePlotMataKuliang(String id) {
		// TODO Auto-generated method stub
		this.plotMataKuliahRespo.deleteById(Long.parseLong(id));
	}

}
