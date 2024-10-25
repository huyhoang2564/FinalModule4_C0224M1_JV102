package com.example.ordermanagementsystem.repositories;

import com.example.ordermanagementsystem.entities.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<DonHang, Integer> {
    List<DonHang> findByNgayMuaBetween(LocalDateTime start, LocalDateTime end);
}
