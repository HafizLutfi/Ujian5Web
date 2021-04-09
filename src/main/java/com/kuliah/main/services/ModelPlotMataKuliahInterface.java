package com.kuliah.main.services;

import java.util.List;

import com.kuliah.main.entity.PlotMataKuliah;

public interface ModelPlotMataKuliahInterface {

	public List<PlotMataKuliah> getAllPlotMataKuliah();
	public PlotMataKuliah getPlotMataKuliahById(String id);
	
	public PlotMataKuliah addPlotMataKuliah(PlotMataKuliah plotMataKuliah);
	public void deletePlotMataKuliang(String id);
	
	
}
