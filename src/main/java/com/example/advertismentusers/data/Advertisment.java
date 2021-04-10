package com.example.advertismentusers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="advertisment")
public class Advertisment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adv_id")
    private int id;

    @Column(name = "adv_title")
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="adv_user_id", nullable=false)
    private User user;
}
