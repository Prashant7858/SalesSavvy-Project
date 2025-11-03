package com.example.demo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "jwt_tokens")
public class JWTToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer tokenId; // Unique identifier for each token.

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) 
    private User user; // The user associated with this token.

    @Column(nullable = false, unique = true)
    private String token; // The actual JWT string.

    @Column(nullable = false)
    private LocalDateTime expiresAt; // Expiration time of the token.

    // 🔹 Constructors
    public JWTToken() {}

    public JWTToken(Integer tokenId, User user, String token, LocalDateTime expiresAt) {
        this.tokenId = tokenId;
        this.user = user;
        this.token = token;
        this.expiresAt = expiresAt;
    }

    public JWTToken(User user, String token, LocalDateTime expiresAt) {
        this.user = user;
        this.token = token;
        this.expiresAt = expiresAt;
    }

    // 🔹 Getters & Setters
    public Integer getTokenId() {
        return tokenId;
    }

    public void setTokenId(Integer tokenId) {
        this.tokenId = tokenId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }
}
