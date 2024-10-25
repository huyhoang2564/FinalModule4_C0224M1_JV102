package com.example.ordermanagementsystem.controllers;

import com.example.ordermanagementsystem.entities.DonHang;
import com.example.ordermanagementsystem.repositories.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/don-hang")
public class DonHangController {

    @Autowired
    private DonHangRepository donHangRepository;

    @GetMapping
    public String listDonHang(Model model) {
        List<DonHang> donHangList = donHangRepository.findAll();
        model.addAttribute("donHangList", donHangList);
        return "donhang";
    }

    @GetMapping("/search")
    public String searchDonHang(@RequestParam("start") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDateTime start,
                                @RequestParam("end") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDateTime end,
                                Model model) {
        List<DonHang> donHangList = donHangRepository.findByNgayMuaBetween(start, end);
        model.addAttribute("donHangList", donHangList);
        return "donhang";
    }

    @GetMapping("/edit/{id}")
    public String editDonHang(@PathVariable("id") int id, Model model) {
        DonHang donHang = donHangRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid order ID"));
        model.addAttribute("donHang", donHang);
        return "editDonHang";
    }

    @PostMapping("/edit/{id}")
    public String updateDonHang(@PathVariable("id") int id, @ModelAttribute("donHang") DonHang donHang) {
        donHangRepository.save(donHang);
        return "redirect:/don-hang";
    }
}
