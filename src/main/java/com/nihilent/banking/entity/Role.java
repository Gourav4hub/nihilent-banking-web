package com.nihilent.banking.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role 
{
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleId;

    @Column(name = "role_name",unique = true,nullable = false)
    private String roleName;
}
