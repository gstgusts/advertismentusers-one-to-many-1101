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

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="adv_user_id", referencedColumnName = "user_id", nullable = false)
    private User user;
}
