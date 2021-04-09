package com.kuliah.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kuliah.main.entity.PlotMataKuliah;

public interface PlotMataKuliahRepository extends CrudRepository<PlotMataKuliah, Long> {


	public PlotMataKuliah findByIdPlotMataKuliah(long id);
	
}
