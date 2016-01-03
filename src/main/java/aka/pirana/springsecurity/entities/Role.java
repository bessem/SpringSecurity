/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author aka
 */
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;
    @Column(name="role_name",nullable=false)
    private String roleName;
    public Role() {
    }

    public Role(String roleName) {
            this.roleName = roleName;
    }
    
    public Role(Integer id, String roleName) {
            this.id = id;
            this.roleName = roleName;
    }
    
    public Integer getId() {
            return id;
    }
    
    public void setId(Integer id) {
            this.id = id;
    }
    
    public String getRoleName() {
            return roleName;
    }
    
    public void setRoleName(String roleName) {
            this.roleName = roleName;
    }
    
}
