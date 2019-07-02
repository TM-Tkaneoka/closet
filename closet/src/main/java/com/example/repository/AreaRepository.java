package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {
	//ユーザIDから経度緯度の取得
    @Query(value = "SELECT * FROM areas WHERE area_id = :areaId", nativeQuery = true)
    public List<Area> findArea(@Param("areaId") int areaId);

}