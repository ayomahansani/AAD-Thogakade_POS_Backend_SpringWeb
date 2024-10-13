package lk.ijse.thogakadepos_backend.dao;

import lk.ijse.thogakadepos_backend.entity.impl.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<OrderEntity,String> {
}
