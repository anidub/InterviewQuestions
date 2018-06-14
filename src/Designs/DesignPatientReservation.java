package Designs;

public class DesignPatientReservation {

	List<Doctor> doctors;
	List<Patient> patients;
	
	Map<Disease, Doctor>;
	
	listallappointments();
	
	
	class Patient{
		String name;
		String patientdetails;
		List<Schedule> schedules;
		String id;
		getupcomingappointments();
	}
	
	class Schedule{
		String docname;
		String patientname;
		String starttime;
		String date;
		String endtime;
		String id;
	}
	
	class doctor{
		String name;
		List<Schedule> schedules;
		String id;
		String details;
		getupcomingappointments();
	}
}
