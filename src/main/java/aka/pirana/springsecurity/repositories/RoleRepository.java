/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.repositories;

import aka.pirana.springsecurity.entities.Role;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author aka
 */
public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
