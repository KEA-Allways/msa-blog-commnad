package com.allways.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateRequest {
    @NotBlank(message = "카테고리 이름을 입력해주세요.")
    private String categoryName;
}
