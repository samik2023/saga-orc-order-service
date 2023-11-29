package com.bank.management.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class Event implements Serializable {

    private Long orderId;
    private String eventStatus;
    private String phase;
}

