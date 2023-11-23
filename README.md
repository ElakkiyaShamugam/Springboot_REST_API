# Springboot_REST_API
## Basic Healthcare Appointment System
This is a sample Java / Maven /  Spring Boot based RESTful API that can be used for making and managing appointments in healthcare.

HTTP methods:
1. POST /api/appointments - Book a new appointment.
2. GET /api/appointments - Retrieve all appointments for a user.
3. PUT /api/appointments/{appointmentId} - Reschedule an existing appointment.
4. DELETE /api/appointments/{appointmentId} - Cancel an appointment.
5. GET /api/patients/{patientId} - Access a patient's records.

These services has been tested using Postman tool and in-memory H2 database with default port 8080.

### URLs: 
(Replace value for placeholder in URL)
1. POST      -  http://localhost:8080/api/appointments   - Book a new appointment.
2. GET       -  http://localhost:8080/api/appointments?patientName={patientName} - Retrieve all appointments for a user.
3. PUT       -  http://localhost:8080/api/appointments/{appointmentId}  - Reschedule an existing appointment.
4. DELETE    -  http://localhost:8080/api/appointments/{appointmentId} - Cancel an appointment.
5. GET       -  http://localhost:8080/api/patients/{patientId} - Access a patient's records.
   
h2 console url - http://localhost:8080/h2-console
(username and password for h2 DB mentioned in application.properties file)
or to test with other database, add dependencies in pom.xml and cofigurations in properties file.

After downloading this project, import it in SpringToolSuit and can Run and test the application.

### Sample json request to book a new appointment :

{
        "patientName": "Nive",
        "doctorName": "Dr.Sathish",
        "appointmentDate": "2023-12-26",
        "appointmentTime": "01:35:00",
        "mobileNumber" : "9003465024",
        "place": "Banglore"
}
