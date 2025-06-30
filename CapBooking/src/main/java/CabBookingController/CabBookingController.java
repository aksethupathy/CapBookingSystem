package CabBookingController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CabBookingModel.Customer;
import CabBookingService.CabBookingCustomerService;

@RestController
@RequestMapping("/Cab/BookingSystem/")
public class CabBookingController {
 
	@Autowired
	private CabBookingCustomerService cabBookingCustomerService;
	public ResponseEntity<String> CustomerRegistration(@RequestBody Customer Customer)
	{
		if(!Customer.getPassword().contentEquals(Customer.getConfirmPassword()))
				{
			     return ResponseEntity.badRequest().body("Password and confirm password do not match");
				}
		Customer CustomerRegistration = cabBookingCustomerService.RegistorCutomer(Customer);
		
		if(CustomerRegistration !=null)
		{
			return ResponseEntity.ok(" Registration SuceessFully"); 
		}else
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong during registration");
		}
		 
		
	}
	
}
