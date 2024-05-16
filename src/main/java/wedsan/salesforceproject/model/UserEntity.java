package wedsan.salesforceproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USUARIO_SALESFORCE")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "SOBRENOME")
    private String fullname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SENHA")
    private String password;

    @Column(name = "CARGO")
    private String position;

    @Column(name = "TELEFONE")
    private String telephoneNumber;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPRESA_ID", referencedColumnName = "ID")
    private UserCompanyEntity userCompanyEntity;

    public UserEntity() {
    }

    public UserEntity(String name, String fullname, String email, String password, String position, String telephoneNumber,  UserCompanyEntity userCompanyEntity) {
        this.name = name;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.position = position;
        this.userCompanyEntity = userCompanyEntity;
        this.telephoneNumber = telephoneNumber;
    }

    public UserEntity(Long id, String name, String fullname, String email, String password, String position, String telephoneNumber, UserCompanyEntity userCompanyEntity) {
        this.id = id;
        this.name = name;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.userCompanyEntity = userCompanyEntity;
        this.position = position;
        this.telephoneNumber = telephoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public UserCompanyEntity getUserCompanyEntity() {
        return userCompanyEntity;
    }

    public void setUserCompanyEntity(UserCompanyEntity userCompanyEntity) {
        this.userCompanyEntity = userCompanyEntity;
    }
}
