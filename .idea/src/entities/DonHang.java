package com.example.ordermanagementsystem.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "don_hang")
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maDonHang;

    private LocalDateTime ngayMua;
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_sp")
    private SanPham sanPham;

    // Getters and Setters
}
