package com.iclinicemr.training.domain.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role extends BaseEntity{

    @Column(name="role")
    private String role;

    @Column(name="description")
    private String description;

    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="role_id"))
//    @Column(name="user_id")
//    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="role_id", referencedColumnName = "id"))
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="role_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
//    @JoinTable(name="user_roles",
//            joinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")}
//    )

    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}
