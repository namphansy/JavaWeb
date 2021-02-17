package psn.model.dao;

import java.util.List;

import psn.model.entity.Color;

public interface ColorDAO {
	public List<Color> listColor();
	public Color findById(int colorId); 
}