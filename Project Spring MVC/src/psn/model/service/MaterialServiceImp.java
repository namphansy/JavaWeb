package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.MaterialDAO;
import psn.model.entity.Material;

@Service
public class MaterialServiceImp implements MaterialService {
	
	@Autowired
	private MaterialDAO materialDao;
	
	@Override
	public List<Material> listMaterial() {
		// TODO Auto-generated method stub
		return materialDao.listMaterial();
	}

}
