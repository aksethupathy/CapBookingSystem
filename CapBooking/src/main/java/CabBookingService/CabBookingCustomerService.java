package CabBookingService;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import CabBookingModel.Customer;
import CabBookingRepository.CabBookingCustomerRepository;

public class CabBookingCustomerService {

	@Autowired
	private CabBookingCustomerRepository cabBookingCustomerRepository;
	public Customer RegistorCutomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Optional<Customer> ExsitingEmail = cabBookingCustomerRepository.findByEmail(customer.getEmail());
		if(ExsitingEmail.isPresent()){
			throw new RuntimeException("Email already exists!");
		}
	
		Customer RegistorCustomer = cabBookingCustomerRepository.save(customer);
		return RegistorCustomer;
	}

}
