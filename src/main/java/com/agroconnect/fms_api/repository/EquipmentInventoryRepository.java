package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.EquipmentInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentInventoryRepository extends JpaRepository<EquipmentInventory, Integer> {
}