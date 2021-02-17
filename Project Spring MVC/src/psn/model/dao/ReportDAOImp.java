package psn.model.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psn.model.entity.ReportItem;

@Repository
public class ReportDAOImp implements ReportDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	//Số hóa đơn theo số ngày(limit)
	@Override
	public List<ReportItem> reportReceipt(Date date, int limit) {
		List<ReportItem> list = new ArrayList<>();
		for (int i = limit - 1; i >= 0; i--) {
			Date day = subDays(date, i);
			ReportItem reportItem = new ReportItem();
			reportItem.setTime(covertD2S(day));
			reportItem.setValue(countItemByDate(day));
			list.add(reportItem);
		}

		return list;
	}

	private int countItemByDate(Date date) {
		Session session = null;
		Transaction transaction = null;
		int numberItem = 0;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			long ni;
			ni = (long) session
					.createQuery("SELECT count(*) FROM Orders WHERE created = :date")
					.setParameter("date", date).uniqueResult();
			
			numberItem = Long.valueOf(ni).intValue();
			
//			numberItem = 5;
//			"SELECT count(*) FROM Orders WHERE DATE_FORMAT(created,'%Y-%m-%d') = :date"
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			if (session != null)
				session.close();
		}

		return numberItem;
	}

	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date subDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}

	private String covertD2S(Date date) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		return df.format(date);
	}
}
