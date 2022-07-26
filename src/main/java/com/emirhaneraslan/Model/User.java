package com.emirhaneraslan.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "register")

@NamedQueries({
        @NamedQuery(name = "User.findAll",
                query = "SELECT u FROM User u"),
        @NamedQuery(name = "User.findById",
                query = "SELECT u FROM User u WHERE u.userId = :userId"),
        @NamedQuery(name ="User.findByUserFirstName",
                query = "SELECT u FROM User u WHERE u.userFirstName=: userFirstName")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false, nullable = false)
    private Long userId;

    @Column(name = "user_first_name", nullable = false)
    private String userFirstName;

    @Column(name = "user_last_name", nullable = false)
    private String userLastName;

    @Column(name = "user_e_mail", nullable = false)
    private String userMail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;
}
