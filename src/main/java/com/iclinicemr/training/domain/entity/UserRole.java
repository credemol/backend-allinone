package com.iclinicemr.training.domain.entity;

import org.springframework.data.domain.Auditable;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRole extends BaseEntity {

//    @EmbeddedId
//    UserRoleId userRoleId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @MapsId("user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
//    @MapsId("role_id")
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private Role role;

//    public UserRole(UserRoleId userRoleId) {
//        this.userRoleId = userRoleId;
//    }

    public UserRole(User user, Role role) {
        this.user = user;
        this.role = role;
    }

    public UserRole() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public UserRoleId getUserRoleId() {
//        return userRoleId;
//    }
//
//    public void setUserRoleId(UserRoleId userRoleId) {
//        this.userRoleId = userRoleId;
//    }
}
