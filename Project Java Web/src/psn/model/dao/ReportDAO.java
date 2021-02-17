package psn.model.dao;

import java.util.List;
import java.util.Date;
import psn.model.entity.ReportItem;

public interface ReportDAO {
	public List<ReportItem> reportReceipt(Date date, int limit);
}
