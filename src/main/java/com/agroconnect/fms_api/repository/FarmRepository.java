package com.agroconnect.fms_api.repository;

import com.agroconnect.fms_api.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FarmRepository extends JpaRepository<Farm, Integer> {
    List<Farm> findByFarmerId(Integer farmerId);
}
