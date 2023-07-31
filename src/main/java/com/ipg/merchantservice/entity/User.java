package com.ipg.merchantservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String name;
    @NotBlank
    private String username;
    @Email
    @NotBlank
    private  String email;
    @NotBlank
    private String password;
    private String partnerId;
    @NotBlank
    private String roles;
    @NotBlank
    private String realm;
    private String merchantId;
    @NotBlank
    private String status;
    @NotBlank
    private String photoUrl;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getRealm() {
        return realm;
    }

    public String getStatus() {
        return status;
    }

    public String getRoles() {
        return roles;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}
