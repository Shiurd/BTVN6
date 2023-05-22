package com.example.btvn_buoi6.service;

import com.example.btvn_buoi6.entity.SanPham;

import java.util.List;

public interface SanPhamService {

    List<SanPham> getAll();

    void addSanPham(SanPham sanPham);

    void removeSanPham(SanPham sanPham);

    List<SanPham> sreachSanPhamUseId(Integer id);

    List<SanPham> sreachSanPhamUseTen(String ten);

    SanPham detailSanPham(Integer id);

    void removeSanPham(Integer id);

    void updateSanPham(SanPham sanPham);

    List<SanPham> searchSanPham(String name);
}
