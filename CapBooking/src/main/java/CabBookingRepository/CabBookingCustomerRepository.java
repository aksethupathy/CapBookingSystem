package CabBookingRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import CabBookingModel.Customer;
import CabBookingService.Optinol;

public interface CabBookingCustomerRepository extends JpaRepository<Customer, Long > {

	Optinol<Customer> findByEmail();

}
