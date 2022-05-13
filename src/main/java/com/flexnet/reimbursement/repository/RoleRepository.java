package com.flexnet.reimbursement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flexnet.reimbursement.model.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, String>{

}
