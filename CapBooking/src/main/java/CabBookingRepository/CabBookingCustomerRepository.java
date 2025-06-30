package CabBookingRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import CabBookingModel.Customer;



public interface CabBookingCustomerRepository extends JpaRepository<Customer, Long > {

	Optional<Customer> findByEmail(String email);
	Optional<Customer> findByMobileNo(int phoneNumber);

}
