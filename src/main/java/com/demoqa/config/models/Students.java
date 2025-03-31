package com.demoqa.config.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder

public class Students {
    private String name;
    private String surName;
    private String email;
    private String phone;


}