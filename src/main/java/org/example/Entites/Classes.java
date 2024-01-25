package org.example.Entites;

import lombok.*;

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
@ToString
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


    @OneToMany(mappedBy = "aClass", fetch = FetchType.EAGER)
    private List<Student> students;
}
