package com.example.btvn_buoi6.controller;

import com.example.btvn_buoi6.entity.SanPham;
import com.example.btvn_buoi6.service.SanPhamService;
import com.example.btvn_buoi6.service.impl.SanPhamServiceImpl;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SanPhamController {
    private SanPhamService sanPhamService = new SanPhamServiceImpl();

    private List<SanPham> listSanPham = new ArrayList<>();

    @GetMapping("/san-pham/view-all")
    public String viewAll(Model model) {
        model.addAttribute("allSP", new SanPham());
        listSanPham = sanPhamService.getAll();
        model.addAttribute("listSanPham", listSanPham);
        return "/san-pham";
    }

    @GetMapping("/san-pham/detail/{id}")
    public String detailSanPham(@ModelAttribute("allSP") SanPham sanPham,
                                @PathVariable("id") String id, Model model) {
        SanPham sp = sanPhamService.detailSanPham(Integer.valueOf(id));
        model.addAttribute("detailSP", sp);
        listSanPham = sanPhamService.getAll();
        model.addAttribute("listSanPham", listSanPham);
        return "/san-pham";
    }

    @GetMapping("/san-pham/remove/{id}")
    public String removeSanPham(@PathVariable("id") String id, Model model) {
        SanPham sp = sanPhamService.detailSanPham(Integer.valueOf(id));
        sanPhamService.removeSanPham(sp);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewDetailSanPham(@ModelAttribute("allSP") SanPham sanPham,
                                    @PathVariable("id") String id, Model model) {
        SanPham sp = sanPhamService.detailSanPham(Integer.valueOf(id));
        model.addAttribute("detailSP", sp);
        return "/san-pham-view-update";
    }

    @PostMapping("/san-pham/add")
    public String addSanPham(@Valid @ModelAttribute("allSP") SanPham sanPham,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            listSanPham = sanPhamService.getAll();
            model.addAttribute("listSanPham", listSanPham);
            return "/san-pham";
        }
        sanPhamService.addSanPham(sanPham);
        return "redirect:/san-pham/view-all";
    }

    @PostMapping("/san-pham/update")
    public String updateSanPham(@Valid @ModelAttribute("allSP") SanPham sanPham,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/san-pham-view-update";
        }
        sanPhamService.updateSanPham(sanPham);
        return "redirect:/san-pham/view-all";
    }

    @GetMapping("/san-pham/search")
    public String searchSanPham(@RequestParam("searchValue") String sreachName,
                                @ModelAttribute("allSP") SanPham sanPham, Model model) {
        listSanPham = sanPhamService.searchSanPham(sreachName);
        model.addAttribute("listSanPham", listSanPham);
        return "/san-pham";
    }

}
