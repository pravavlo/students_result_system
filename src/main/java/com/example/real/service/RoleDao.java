package com.example.real.service;

import com.example.real.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,String> {
}
