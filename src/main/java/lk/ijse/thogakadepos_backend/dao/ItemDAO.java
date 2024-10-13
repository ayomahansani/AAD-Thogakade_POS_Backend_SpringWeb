package lk.ijse.thogakadepos_backend.dao;

import lk.ijse.thogakadepos_backend.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<ItemEntity,String> {
}
