package com.school.management.SchoolManagementApp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;
    @ManyToMany(mappedBy = "lessons")
    private Set<Student> students=new HashSet<>();

    @OneToOne(mappedBy = "lesson",fetch =FetchType.LAZY)
    private Teacher teacher;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreRemove
    private void preRemove(){
        students.forEach(student -> student.setLessons(null));
        teacher.setLesson(null);
    }

}
