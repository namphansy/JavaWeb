package psn.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.ColorDAO;
import psn.model.entity.Color;

@Service
public class ColorServiceImp implements ColorService{
	
	@Autowired
	private ColorDAO colorDao;
	
	@Override
	public List<Color> listColor() {
		// TODO Auto-generated method stub
		return colorDao.listColor();
	}

	@Override
	public Color findById(int colorId) {
		// TODO Auto-generated method stub
		return colorDao.findById(colorId);
	}

}
