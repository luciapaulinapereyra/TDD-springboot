package com.example.demo.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cotization")
public class CotizationModel {
	private Date checkDate;
	private Date paymentDay;

	public Calendar calculatePaymentDate(Calendar checkDate) {
		return null;

	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(Date paymentDay) {
		this.paymentDay = paymentDay;
	}

}
