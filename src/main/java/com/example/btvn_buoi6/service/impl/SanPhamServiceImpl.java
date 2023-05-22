package com.example.btvn_buoi6.service.impl;

import com.example.btvn_buoi6.entity.SanPham;
import com.example.btvn_buoi6.service.SanPhamService;

import java.util.ArrayList;
import java.util.List;

public class SanPhamServiceImpl implements SanPhamService {

    private List<SanPham> listSanPham = new ArrayList<>();

    private List<SanPham> listSearch = new ArrayList<>();

    public SanPhamServiceImpl() {
        listSanPham.add(new SanPham(1, "Ma001", "Tao", "1", 25000));
        listSanPham.add(new SanPham(2, "Ma002", "Cam", "2", 30000));
        listSanPham.add(new SanPham(3, "Ma003", "Sau rieng", "5", 45000));
        listSanPham.add(new SanPham(4, "Ma004", "Mit", "2", 50000));
        listSanPham.add(new SanPham(5, "Ma005", "Le", "3", 20000));
    }

    @Override
    public List<SanPham> getAll() {
        return listSanPham;
    }

    @Override
    public void addSanPham(SanPham sanPham) {
        listSanPham.add(sanPham);
    }

    @Override
    public void updateSanPham(SanPham sanPham) {
        for (SanPham sp : listSanPham) {
            if (sp.getId() == sanPham.getId()) {
                sp.setMa(sanPham.getMa());
                sp.setTen(sanPham.getTen());
                sp.setLoai(sanPham.getLoai());
                sp.setGia(sanPham.getGia());
            }
        }
    }

    @Override
    public void removeSanPham(SanPham sanPham) {
        listSanPham.remove(sanPham);
    }

    @Override
    public List<SanPham> sreachSanPhamUseId(Integer id) {
        listSearch.clear();
        for (SanPham sp : listSanPham) {
            if (sp.getId() == id) {
                listSearch.add(sp);
            }
        }
        return listSearch;
    }

    @Override
    public List<SanPham> sreachSanPhamUseTen(String ten) {
        listSearch.clear();
        for (SanPham sp : listSanPham) {
            if (sp.getTen().equalsIgnoreCase(ten)) {
                listSearch.add(sp);
            }
        }
        return listSearch;
    }

    @Override
    public SanPham detailSanPham(Integer id) {
        for (SanPham sp : listSanPham) {
            if (sp.getId() == id) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public void removeSanPham(Integer id) {
        for (SanPham sp : listSanPham) {
            if (sp.getId() == id) {
                listSanPham.remove(sp);
            }
        }
    }

    @Override
    public List<SanPham> searchSanPham(String name) {
        listSearch.clear();
        for (SanPham sp : listSanPham) {
            if (sp.getTen().contains(name)) {
                listSearch.add(sp);
            }
        }
        return listSearch;
    }
}
