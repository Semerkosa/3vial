package com.jointrivial.server.models.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "data")
public class Data extends BaseEntity {
    private String email;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Survey survey;


    public Data() {
    }

    @OneToOne(mappedBy = "data", targetEntity = Survey.class)
    @PrimaryKeyJoinColumn
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    @Email(regexp = "^(.+)@(\\S+)$")
    @Column(unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
