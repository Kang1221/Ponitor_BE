package pebite.Ponitor_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pebite.Ponitor_BE.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
