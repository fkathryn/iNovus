package com.testcase.web.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatsDto {
    private Long id;
    private String name;
    private Integer votes;
    private String image;
    private boolean participate;
}
