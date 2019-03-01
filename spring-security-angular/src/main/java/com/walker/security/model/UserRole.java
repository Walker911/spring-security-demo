package com.walker.security.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author walker
 * @date 2018/12/20
 */
@Data
@Entity
public class UserRole {

    @Id
    private String id;

    private String userId;

    private String roleId;
}
