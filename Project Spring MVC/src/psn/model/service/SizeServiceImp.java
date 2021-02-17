package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.SizeDAO;
import psn.model.entity.Size;

@Service
public class SizeServiceImp implements SizeService {
	
	@Autowired
	private SizeDAO sizeDao;
	
	@Override
	public List<Size> listSizes() {
		// TODO Auto-generated method stub
		return sizeDao.listSizes();
	}

}
