package com.dts.miniproject.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Id
    private Long id;
    private String username;
    private String password;
    @Column(name = "is_account_locked")
    private Boolean isAccountLocked;
    @Column(name = "is_enabled")
    private Boolean isEnabled;

    // @OneToOne
    // @MapsId
    // @JoinColumn(name = "id")
    // private Guru guru;

    // @OneToOne
    // @MapsId
    // @JoinColumn(name = "id")
    // private Siswa siswa;
    @JsonProperty(access = Access.WRITE_ONLY)
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Entitas entitas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles;
}
