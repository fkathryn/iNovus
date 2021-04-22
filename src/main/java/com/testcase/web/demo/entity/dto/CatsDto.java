package com.testcase.web.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatsDto {
    private Integer id;
    private String name;
    private Integer votes;
    private boolean participate;
}
