package com.edudemic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edudemic.entities.Libro;
import com.edudemic.entities.Material;
import com.edudemic.repository.MaterialRepository;

@Service
public class MaterialService {

	private MaterialRepository materialRepository;
	public MaterialService(MaterialRepository materialRepository) {
		this.materialRepository=materialRepository;
	}
	
	public Material registrarMaterial(Material m) {
		
		return materialRepository.save(m);
	}
	public List<Material>listarMaterial(){
		return materialRepository.findAll();
	}
	public Material materialObjeto(long id) {
		return materialRepository.objetoM(id);
	}
	// modificar
		public Material updateMaterial(Material material) {
			return materialRepository.save(material);
		}

		public Material getMaterialById(Long id) {
			return materialRepository.findById(id).get();
		}

		// eliminar
		
	public List<Material>listarMaterialesMentoria(Long id){
		return materialRepository.listaMaterialesMentoria(id);
	}
	//falta la otra lista
}
