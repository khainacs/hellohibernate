package org.example.Entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "className")
    private String className;

    @Column(name = "semester")
    private String semester;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classId", nullable = true)
    private Classes aClass;

    @OneToMany(mappedBy = "aStudent", fetch = FetchType.LAZY)
    private List<Subject> subjects;
}