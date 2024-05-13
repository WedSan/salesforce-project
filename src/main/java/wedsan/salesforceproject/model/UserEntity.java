package wedsan.salesforceproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USER_SALESFORCE")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String companySector;

    @Column(nullable = false)
    private int telephoneNumber;

    public UserEntity() {
    }

    public UserEntity(String name, String email, String password, String companyName, String position, String companySector, int telephoneNumber) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.position = position;
        this.companySector = companySector;
        this.telephoneNumber = telephoneNumber;
    }

    public UserEntity(Long id, String name, String email, String password, String companyName, String position, String companySector, int telephoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.position = position;
        this.companySector = companySector;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompanySector() {
        return companySector;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
