package ee.bcs.valiit.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer2Repository extends JpaRepository<Customer2, Long> {
    Customer2 findByCustomerName(String name);
}
