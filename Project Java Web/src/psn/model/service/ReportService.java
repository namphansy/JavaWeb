package psn.model.service;

import java.util.Date;
import java.util.List;

import psn.model.entity.ReportItem;

public interface ReportService {
	public List<ReportItem> reportReceipt(Date date, int limit);
}
