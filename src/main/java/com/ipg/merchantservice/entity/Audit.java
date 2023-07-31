package com.ipg.merchantservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "audits")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank
    private String ipAddress;

    @NotBlank
    private String accessEndpoint;

    @NotBlank
    private String controllerGroup;

    private String createdBy;
    

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    public void setAccessEndpoint(String accessEndpoint) {
        this.accessEndpoint = accessEndpoint;
    }

    public void setControllerGroup(String controllerGroup) {
        this.controllerGroup = controllerGroup;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
