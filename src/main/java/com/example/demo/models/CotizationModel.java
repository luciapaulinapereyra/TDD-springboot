package com.example.demo.models;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cotization")
public class CotizationModel {
	private Date checkDate;
	private Date paymentDay;
	private Integer operationTerm;
	private Double checkAmount;
	private Double dailyRate;
	private Double interests;
	private Double expenseRate;
	private Double managmentExpense;
	private Double iva;
	private Double netOperation;

	public Calendar calculatePaymentDate(Calendar checkDate) {
		checkDate.add(Calendar.DAY_OF_YEAR, 2);
		setPaymentDay(checkDate.getTime());
		return checkDate;

	}

	public void calculateOperationTerm() {
		Date dateNow = new Date();
		dateNow.getTime();
		int days = (int) ((paymentDay.getTime() - dateNow.getTime()) / 86400000);
		days = days + 1;
		setOperationTerm(days);

	}

	public void calculateInterests() {
		Double dailyRate = getDailyRate() / 100;
		Double total = getCheckAmount() * getOperationTerm() * dailyRate;
		setInterests(total);
	}

	public void calculateExpenseManagement() {
		// Gasto de gestión: Monto del cheque * Tasa de gasto
		Double expenseRate = getExpenseRate() / 100;
		Double total = getCheckAmount() * expenseRate;
		setManagmentExpense(Math.round(total * 100d) /100d);
	}

	public void calculateIva() {
		// Iva: (intereses + gasto de gestión) * 21%
		Double total = (getInterests() + getManagmentExpense()) * 0.21;
		setIva(total);

	}

	public void calculateNetOperation() {
		// Neto de operación: Monto - Intereses - Gasto de gestión - Iva
		Double total = getCheckAmount() - getInterests() - getManagmentExpense() - getIva();
		setNetOperation(total);
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

	public Integer getOperationTerm() {
		return operationTerm;
	}

	public void setOperationTerm(Integer operationTerm) {
		this.operationTerm = operationTerm;
	}

	public Double getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(Double checkAmount) {
		this.checkAmount = checkAmount;
	}

	public Double getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(Double dailyRate) {
		this.dailyRate = dailyRate;
	}

	public Double getInterests() {
		return interests;
	}

	public void setInterests(Double interests) {
		this.interests = interests;
	}

	public Double getExpenseRate() {
		return expenseRate;
	}

	public void setExpenseRate(Double expenseRate) {
		this.expenseRate = expenseRate;
	}

	public Double getManagmentExpense() {
		return managmentExpense;
	}

	public void setManagmentExpense(Double managmentExpense) {
		this.managmentExpense = managmentExpense;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getNetOperation() {
		return netOperation;
	}

	public void setNetOperation(Double netOperation) {
		this.netOperation = netOperation;
	}

}
