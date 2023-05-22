package com.example.btvn_buoi6.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SanPham {

    @NotNull(message = "Không được để trống")
    private Integer id;

    @NotEmpty(message = "Không được để trống")
    private String ma;

    @NotEmpty(message = "Không được để trống")
    private String ten;

    @NotEmpty(message = "Không được để trống")
    private String loai;

    @NotNull(message = "Không được để trống")
    @Min(value = 150, message = "phải lớn hơn 150")
    private Integer gia;
}
