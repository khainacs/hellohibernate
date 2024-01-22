package org.example.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classes extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "floor", nullable = false, length = 50)
    private String floor;

    @Column(name = "dateStart", nullable = true, length = 11)
    private Date dateStart;

    @Column(name = "timeStart", nullable = true, length = 11)
    private Time timeStart;

    @Column(name = "subject", nullable = true, length = 255)
    private String subject;

    @OneToMany(mappedBy = "aClass", fetch = FetchType.LAZY)
    private List<Student> students;
}
