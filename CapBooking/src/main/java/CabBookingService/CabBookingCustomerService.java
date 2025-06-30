package CabBookingService;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import CabBookingModel.Customer;
import CabBookingRepository.CabBookingCustomerRepository;

public class CabBookingCustomerService {

	@Autowired
	private CabBookingCustomerRepository cabBookingCustomerRepository;
	
	@Autowired PasswordEncoder passwordEncoder;
	public Customer RegistorCutomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Optional<Customer> ExsitingEmail = cabBookingCustomerRepository.findByEmail(customer.getEmail());
		if(ExsitingEmail.isPresent()){
			throw new RuntimeException("Email already exists!");
		}
		
		Optional<Customer> ExsitingMobileNo = cabBookingCustomerRepository.findByMobileNo(customer.getPhoneno());
	    if(ExsitingMobileNo.isPresent())
	    {
	    	throw new RuntimeException("Email already exists!");
	    }
	    String password = passwordEncoder.encode(customer.getPassword());
	    customer.setPassword(password);
		Customer RegistorCustomer = cabBookingCustomerRepository.save(customer);
		return RegistorCustomer;
	}
	public String login(String email, String password) {
		Optional<Customer> customerMailid = cabBookingCustomerRepository.findByEmailid(email);
		
		if(customerMailid.isEmpty())
		{
			return "Invalid Email Id";
		}
		
		 Customer customer = customerMailid.get();
		 
		 if(customer.getPassword().equals(password))
		 {
			return "Login SucessFully" ;
		 }else {
			 return "invalid password";
		 }
		 
		
	}

}
