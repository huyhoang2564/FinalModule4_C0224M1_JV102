package com.example.ordermanagementsystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "loai_san_pham")
public class LoaiSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int maLoaiSp;
    private String tenLoaiSp;

    // Getters and Setters
}
