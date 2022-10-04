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
	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPaymentDate() throws ParseException {
		CotizationModel cot = new CotizationModel();
		Calendar calendar = Calendar.getInstance();
		DateFormat formatt = new SimpleDateFormat("dd/M/yy");
		Date checkDate = formatt.parse("11/11/2022");
		Date expectedDate = formatt.parse("13/11/2022");
		calendar.setTime(checkDate);
		cot.calculatePaymentDate(calendar);
		calendar.setTime(expectedDate);
		assertEquals(calendar.getTime(), cot.getPaymentDay());
	}

}
