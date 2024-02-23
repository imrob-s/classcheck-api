package com.imrob.classcheckapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_attendance")
public class Attendance {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDateTime dateTime;
        @ManyToOne
        @JoinColumn(name = "student_id")
        Student student;
        @ManyToOne
        @JoinColumn(name = "course_id")
        Course course;

        public Attendance() {
        }

        public Attendance(Long id, LocalDateTime dateTime, Student student, Course course) {
                this.id = id;
                this.dateTime = dateTime;
                this.student = student;
                this.course = course;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public LocalDateTime getDateTime() {
                return dateTime;
        }

        public void setDateTime(LocalDateTime dateTime) {
                this.dateTime = dateTime;
        }

        public Student getStudent() {
                return student;
        }

        public void setStudent(Student student) {
                this.student = student;
        }

        public Course getCourse() {
                return course;
        }

        public void setCourse(Course course) {
                this.course = course;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Attendance that = (Attendance) o;

            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return id != null ? id.hashCode() : 0;
        }
}
