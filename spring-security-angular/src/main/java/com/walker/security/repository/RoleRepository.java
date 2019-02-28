package com.walker.security.repository;

import com.walker.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author walker
 * @date 2018/12/21
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     *  find roles by user id
     *
     * @param userId
     * @return
     */
    @Query(value = "select a.id, a.name from role a inner join user_role b " +
            "on a.id = b.role_id where b.user_id = :userId", nativeQuery = true)
    List<Role> findRolesByUserId(String userId);
}
