package ee.valiit.back_jommu.domain.userrole.user;

import ee.valiit.back_jommu.domain.profile.Profile;
import ee.valiit.back_jommu.domain.userrole.role.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile profile;

    @Size(max = 50)
    @NotNull
    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Size(max = 50)
    @NotNull
    @Column(name = "password", nullable = false, length = 50)
    private String password;


}