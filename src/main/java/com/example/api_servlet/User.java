package com.example.api_servlet;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

// @Table nome da tabela na DB
@Table("users")
// @Id é um id dentro da tabela na DB
public record User(@Id Long id, String username, String password, String email) {

}
