package org.example.session04.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "identities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cccd",length = 12)
    private String cccd;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
