package psn.model.service;

import java.util.List;

import psn.model.entity.Color;

public interface ColorService {
	public List<Color> listColor();
	public Color findById(int colorId);
}
