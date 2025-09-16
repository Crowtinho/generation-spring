package com.crow.blog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "text is required")
    @Column(nullable = false)
    private String text;


    @CreatedDate
    @Column(nullable = false,updatable = false)
    private LocalDateTime createAt;


    @ManyToOne(optional = false)
    @JoinColumn(name = "posteo_id", nullable = false)
    @JsonBackReference
    private Posteo posteo;
}
