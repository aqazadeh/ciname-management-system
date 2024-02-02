package com.aqazadeh.cinamemanagementsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Author: Rovshan Aghayev
 * Version: v1.0
 * Date: 30.01.2024
 * Time: 19:25
 */
@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;

}
