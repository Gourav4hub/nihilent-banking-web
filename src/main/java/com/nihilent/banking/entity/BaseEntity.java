package com.nihilent.banking.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.springframework.data.convert.JodaTimeConverters.LocalDateTimeToDateConverter;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseEntity 
{
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	private Integer createdBy;
	private Integer updatedBy;
}
