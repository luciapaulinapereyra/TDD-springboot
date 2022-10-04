package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CotizationModelTest {
	CotizationModel cot = new CotizationModel();
	Calendar calendar = Calendar.getInstance();
	DateFormat formatt = new SimpleDateFormat("dd/M/yy");

	@BeforeEach
	void setUp() throws Exception {
		Date checkDate = formatt.parse("11/10/2022");
		calendar.setTime(checkDate);
		cot.calculatePaymentDate(calendar);
	}

	@AfterEach
	void tearDown() throws Exception {
		cot = null;
	}

	@Test
	void testGetPaymentDate() throws ParseException {
		Calendar calendar = Calendar.getInstance();
		Date expectedDate = formatt.parse("13/10/2022");
		calendar.setTime(expectedDate);
		assertEquals(calendar.getTime(), cot.getPaymentDay());
	}

	@Test
	void testGetOperationTerm() {
		int expected = 9;
		cot.calculateOperationTerm();
		assertEquals(expected, cot.getOperationTerm());
	}

	@Test
	void testGetInteres() {
		cot.setOperationTerm(10);
		cot.setCheckAmount(2000.0);
		cot.setDailyRate(2.5);
		cot.calculateInterests();
		Double expected = 500.0;
		assertEquals(expected, cot.getInterests());
	}

	@Test
	void testGetExpenseManagement() {
		cot.setCheckAmount(50000.0);
		cot.setExpenseRate(3.5);
		cot.calculateExpenseManagement();
		Double expected = 1750.0;
		assertEquals(expected, cot.getManagmentExpense());
	}

	@Test
	void testGetIva() {
		cot.setInterests(700.0);
		cot.setManagmentExpense(25000.0);
		Double expected = 5460.0;
		assertEquals(expected, cot.getIva());
	}

	@Test
	void testGetNetOperation() {
		cot.setCheckAmount(10000.0);
		cot.setInterests(1000.0);
		cot.setManagmentExpense(250.0);
		cot.setIva(500.0);
		Double expected = 8250.0;
		assertEquals(expected, cot.getNetOperation());
	}
}
