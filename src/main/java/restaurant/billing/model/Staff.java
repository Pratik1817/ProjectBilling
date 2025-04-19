package restaurant.billing.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String name;

    private String role;

    private boolean active;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<Bill> bills;
}
