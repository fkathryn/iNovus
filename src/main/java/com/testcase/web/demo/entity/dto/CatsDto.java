package com.testcase.web.demo.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CatsDto {
    private Long id;
    private String image;
    private String name;
    private Integer votes;
}
