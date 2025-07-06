package com.arjun.SpringSecurity.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Automatic getters, setters, component
@Entity  // For JPA to understand this has to be mapped to a relational table.
@Table(name="users")  // Because model name is User but table name is Users.
@NoArgsConstructor  // A constructor with no args to create object.
@AllArgsConstructor // A constructor with all args to set instance values accordingly for each attribute.
public class User {
    @Id     // To set the primary key of table
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
}
