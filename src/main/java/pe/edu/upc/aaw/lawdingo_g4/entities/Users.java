package pe.edu.upc.aaw.lawdingo_g4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "name",length = 20,nullable = false)
    private String name;

    @Column (name = "email",length =50, nullable = false)
    private String email;
    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "numberPhone", unique = true,nullable = false)
    private int phone_num;

    @Column(name ="DNI", unique = true, nullable = false)
    private int dni;

    @Column(name = "bithday", nullable = true)
    private LocalDate birthDay;

    @Column(name="lawyer",nullable = false)
    private boolean lawyer;

    @Column(name="username", length = 30, nullable = false)
    private String username;
    private Boolean enabled;

    //AGREGADO

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private List<Role> roles;


    public Users() {
    }

    public Users(int idUser, String name, String email, String password, int phone_num, int dni, LocalDate birthDay, boolean lawyer, String username, Boolean enabled, List<Role> roles) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_num = phone_num;
        this.dni = dni;
        this.birthDay = birthDay;
        this.lawyer = lawyer;
        this.username = username;
        this.enabled = enabled;
        this.roles = roles;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(int phone_num) {
        this.phone_num = phone_num;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isLawyer() {
        return lawyer;
    }

    public void setLawyer(boolean lawyer) {
        this.lawyer = lawyer;
    }


    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
