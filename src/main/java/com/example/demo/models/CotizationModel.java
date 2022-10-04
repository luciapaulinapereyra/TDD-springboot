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

	public void calculateOperationTerm() {
		// TODO Auto-generated method stub
		
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

	public void calculateInterests() {
		// TODO Auto-generated method stub
		
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

	public void calculateExpenseManagement() {
		// TODO Auto-generated method stub
		
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
