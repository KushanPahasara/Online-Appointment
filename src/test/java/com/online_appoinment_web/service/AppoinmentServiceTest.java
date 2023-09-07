package com.online_appoinment_web.service;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.online_appoinment_web.model.Appoinment;

class AppoinmentServiceTest {

	     private AppoinmentService appoinmentService;
	     private List<Appoinment> testAppointments;

	    @Before
	    public void setUp() {
	    	testAppointments = new ArrayList<>();
	    	appoinmentService = new AppoinmentService();
	    }

	    @Test
	    public void GetAppoinmentByID() throws ClassNotFoundException, SQLException {
	        Appoinment testAppointment = new Appoinment();
	        testAppointment.setAp_id(20);
	        testAppointment.setUser_id(100);
	        testAppointments.add(testAppointment);
	        Appoinment result = appoinmentService.fetchSinglAppoinment(20);
	        assertNotNull(result);
	        assertEquals(20, result.getAp_id());
	    }

	    @Test
	    public void GetAllAppoinments() throws ClassNotFoundException, SQLException {
	        Appoinment testAppointment = new Appoinment();
	        testAppointment.setAp_id(1);
	        testAppointment.setUser_id(100);;
	        Appoinment testAppointment2 = new Appoinment();
	        testAppointment2.setAp_id(2);
	        testAppointment2.setUser_id(456);
	        testAppointments.add(testAppointment2);
	        testAppointments.add(testAppointment2);
	        List<Appoinment> result = appoinmentService.fetchAllAppoinment();
	        assertNotNull(result);
	        
	    }

	    

	    @Test
	    public void AddAppoinment() throws ClassNotFoundException, SQLException {
	        Appoinment testAppointment = new Appoinment();
	        assertTrue(appoinmentService.addAppoinment(testAppointment));
	    }

	    @Test
	    public void DeleteAppointment() throws ClassNotFoundException, SQLException {
	        int appoinmentIDToDelete = 1;
	        assertTrue(appoinmentService.deleteAppoinment(appoinmentIDToDelete));
	    }

	    @Test
	    public void UpdateAppointment() throws ClassNotFoundException, SQLException {
	        Appoinment testAppointment = new Appoinment();
	        assertTrue(appoinmentService.editAppoinment(testAppointment));
	    }


	    
	    }
	


