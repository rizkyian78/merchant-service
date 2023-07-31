package com.ipg.merchantservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "roles")
public class Roles {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String realm;

    @Column(columnDefinition = "jsonb")
    @NotBlank
    private String resources;


    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getName() {
        return name;
    }

    public String getRealm() {
        return realm;
    }

    public String getResources() {
        return resources;
    }
}
