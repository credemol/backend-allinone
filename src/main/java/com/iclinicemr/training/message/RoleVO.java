package com.iclinicemr.training.message;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RoleVO extends BaseVO{
    @NotNull
    @Size(max = 255)
    private String role;

    private String description;

    public RoleVO() {
    }

    public RoleVO(String role, String description) {
        this.role = role;
        this.description = description;
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
}
