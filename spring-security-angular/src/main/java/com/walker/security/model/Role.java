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
public class Role {

    @Id
    private String id;

    private String name;
}
