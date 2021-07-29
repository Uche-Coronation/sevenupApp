package com.coronation.sevenupApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coronation.sevenupApp.model.Region;

public interface RegionRepo extends JpaRepository<Region, Long>{

	public Region findByRegionCode(String regionCode);
	
}
