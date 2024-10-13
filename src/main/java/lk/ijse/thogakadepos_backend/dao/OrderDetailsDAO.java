package lk.ijse.thogakadepos_backend.dao;

import lk.ijse.thogakadepos_backend.entity.impl.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDAO extends JpaRepository<OrderDetailsEntity,String> {
}
