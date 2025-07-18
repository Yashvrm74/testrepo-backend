// // package com.seminarroom.edu.model;

// // import jakarta.persistence.*;
// // import java.util.ArrayList;
// // import java.util.List;

// // @Entity
// // @Table(name = "module_progress")
// // public class ModuleProgress {

// //     @Id
// //     @GeneratedValue(strategy = GenerationType.IDENTITY)
// //     private Long id;

// //     @ManyToOne
// //     @JoinColumn(name = "user_id", nullable = false)
// //     private User user;

// //     @ManyToOne
// //     @JoinColumn(name = "module_id", nullable = false)
// //     private Module module;

// //     @ElementCollection
// //     private List<Long> readingMaterial = new ArrayList<>();

// //     @ElementCollection
// //     private List<Long> video = new ArrayList<>();

// //     @ElementCollection
// //     private List<Long> assignment = new ArrayList<>();

// //     private boolean quiz;
// //     private boolean completed;

// //     // Getters and Setters
// //     public Long getId() {
// //         return id;
// //     }

// //     public void setId(Long id) {
// //         this.id = id;
// //     }

// //     public User getUser() {
// //         return user;
// //     }

// //     public void setUser(User user) {
// //         this.user = user;
// //     }

// //     public Module getModule() {
// //         return module;
// //     }

// //     public void setModule(Module module) {
// //         this.module = module;
// //     }

// //     public List<Long> getReadingMaterial() {
// //         return readingMaterial;
// //     }

// //     public void setReadingMaterial(List<Long> readingMaterial) {
// //         this.readingMaterial = readingMaterial;
// //     }

// //     public List<Long> getVideo() {
// //         return video;
// //     }

// //     public void setVideo(List<Long> video) {
// //         this.video = video;
// //     }

// //     public List<Long> getAssignment() {
// //         return assignment;
// //     }

// //     public void setAssignment(List<Long> assignment) {
// //         this.assignment = assignment;
// //     }

// //     public boolean isQuiz() {
// //         return quiz;
// //     }

// //     public void setQuiz(boolean quiz) {
// //         this.quiz = quiz;
// //     }

// //     public boolean isCompleted() {
// //         return completed;
// //     }

// //     public void setCompleted(boolean completed) {
// //         this.completed = completed;
// //     }
// // }
// package com.seminarroom.edu.model;

// import jakarta.persistence.*;

// @Entity
// public class ModuleProgress {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private Long userId;
//     private Long moduleId;

//     private boolean readingMaterial;
//     private boolean video;
//     private boolean assignment;
//     private boolean quiz;

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Long getUserId() {
//         return userId;
//     }

//     public void setUserId(Long userId) {
//         this.userId = userId;
//     }

//     public Long getModuleId() {
//         return moduleId;
//     }

//     public void setModuleId(Long moduleId) {
//         this.moduleId = moduleId;
//     }

//     public boolean isReadingMaterial() {
//         return readingMaterial;
//     }

//     public void setReadingMaterial(boolean readingMaterial) {
//         this.readingMaterial = readingMaterial;
//     }

//     public boolean isVideo() {
//         return video;
//     }

//     public void setVideo(boolean video) {
//         this.video = video;
//     }

//     public boolean isAssignment() {
//         return assignment;
//     }

//     public void setAssignment(boolean assignment) {
//         this.assignment = assignment;
//     }

//     public boolean isQuiz() {
//         return quiz;
//     }

//     public void setQuiz(boolean quiz) {
//         this.quiz = quiz;
//     }
// }
package com.seminarroom.edu.model;

import jakarta.persistence.*;

@Entity
public class ModuleProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long moduleId;

    private boolean readingMaterial;
    private boolean video;
    private boolean assignment;
    private boolean quiz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public boolean isReadingMaterial() {
        return readingMaterial;
    }

    public void setReadingMaterial(boolean readingMaterial) {
        this.readingMaterial = readingMaterial;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAssignment() {
        return assignment;
    }

    public void setAssignment(boolean assignment) {
        this.assignment = assignment;
    }

    public boolean isQuiz() {
        return quiz;
    }

    public void setQuiz(boolean quiz) {
        this.quiz = quiz;
    }
}