package com.iclinicemr.training.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator= ObjectIdGenerators.UUIDGenerator.class, property="@jsonUUID")
public class AuditableEntity {

    @Column(name = "created_on", columnDefinition = "timestamp with time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Column(name = "updated_on", columnDefinition = "timestamp with time zone")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;

    @Column(name = "modified_by")
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @PrePersist
    protected void onCreate()
    {
        createdOn = new Date();
        try {
            createdBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
//            createdBy = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            createdBy = "anonymousUser";
        }
    }

    @PreUpdate
    protected void onUpdate()
    {
        updatedOn = new Date();
        try {
            updatedBy = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
//            updatedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        } catch (Exception e) {
            updatedBy = "anonymousUser";
        }
    }


    public Date getCreatedOn() {
        return createdOn;
    }


    public Date getUpdatedOn() {
        return updatedOn;
    }


    public String getUpdatedBy() {
        return updatedBy;
    }


    public String getCreatedBy() {
        return createdBy;
    }
}
