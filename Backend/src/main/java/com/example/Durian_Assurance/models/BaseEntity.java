package com.example.Durian_Assurance.models;

import jakarta.persistence.Column;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    @CreationTimestamp
    @Column(name="create_at", updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updated;
}
