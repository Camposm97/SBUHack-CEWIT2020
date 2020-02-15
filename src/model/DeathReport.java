package model;

import java.io.Serializable;
import java.util.Date;

public class DeathReport implements Serializable {
	private Date date;
	private double count;

	public DeathReport(Date date, double count) {
		this.date = date;
		this.count = count;
	}

	public Date getDate() {
		return date;
	}

	public double getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "DeathReport [date=" + date + ", count=" + count + "]";
	}
}
