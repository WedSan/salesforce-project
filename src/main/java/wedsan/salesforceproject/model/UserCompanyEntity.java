package wedsan.salesforceproject.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USUARIO_EMPRESA")
public class UserCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String name;

    @Column(name = "MIN_FUNCIONARIOS")
    private int min_employees;

    @Column(name = "MAX_FUNCIONARIOS")
    private int max_employees;

    @Column(name = "SETOR")
    private String companySector;

    public UserCompanyEntity() {
    }

    public UserCompanyEntity(String name, int min_employees, int max_employees, String companySector) {
        this.name = name;
        this.min_employees = min_employees;
        this.max_employees = max_employees;
        this.companySector = companySector;
    }

    public UserCompanyEntity(Long id, String name, int min_employees, int max_employees, String companySector) {
        this.id = id;
        this.name = name;
        this.min_employees = min_employees;
        this.max_employees = max_employees;
        this.companySector = companySector;
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

    public int getMin_employees() {
        return min_employees;
    }

    public void setMin_employees(int min_employees) {
        this.min_employees = min_employees;
    }

    public int getMax_employees() {
        return max_employees;
    }

    public void setMax_employees(int max_employees) {
        this.max_employees = max_employees;
    }

    public String getCompanySector() {
        return companySector;
    }

    public void setCompanySector(String companySector) {
        this.companySector = companySector;
    }
}
