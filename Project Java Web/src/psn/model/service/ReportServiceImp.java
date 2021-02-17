package psn.model.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import psn.model.dao.ReportDAO;
import psn.model.entity.ReportItem;

@Service
public class ReportServiceImp implements ReportService{
	
	@Autowired
	private ReportDAO reportDao;
	
	@Override
	public List<ReportItem> reportReceipt(Date date, int limit) {
		// TODO Auto-generated method stub
		return reportDao.reportReceipt(date, limit);
	}

}
