// package com.seminarroom.edu.controller;
// import java.util.Map;
// import java.util.stream.Collectors;
// import java.util.ArrayList;

// import com.seminarroom.edu.model.Module;
// import com.seminarroom.edu.model.ModuleProgress;
// import com.seminarroom.edu.model.User;
// import com.seminarroom.edu.repository.ModuleProgressRepository;
// import com.seminarroom.edu.repository.ModuleRepository;
// import com.seminarroom.edu.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/api/progress")
// public class ModuleProgressController {

//     @Autowired
//     private ModuleProgressRepository repository;

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private ModuleRepository moduleRepository;

// //     @PostMapping
// //     public ResponseEntity<?> saveProgress(@RequestBody ModuleProgress progress) {
// //         if (progress.getUser() == null || progress.getModule() == null) {
// //             return ResponseEntity.badRequest().body("User or Module is missing in request");
// //         }

// //         Long userId = progress.getUser().getId();
// //         Long moduleId = progress.getModule().getId();

// //         Optional<User> userOpt = userRepository.findById(userId);
// //         Optional<Module> moduleOpt = moduleRepository.findById(moduleId);

// //         if (userOpt.isEmpty() || moduleOpt.isEmpty()) {
// //             return ResponseEntity.badRequest().body("User or Module not found");
// //         }

// //         Optional<ModuleProgress> existingOpt = repository.findByUserAndModule(userOpt.get(), moduleOpt.get());

// //         ModuleProgress existing = existingOpt.orElseGet(() -> {
// //             ModuleProgress newProgress = new ModuleProgress();
// //             newProgress.setUser(userOpt.get());
// //             newProgress.setModule(moduleOpt.get());
// //             return newProgress;
// //         });

// //        useEffect(() => {
// //   if (
// //     completed.readingMaterial.length > 0 ||
// //     completed.video.length > 0 ||
// //     completed.assignment.length > 0 ||
// //     completed.quiz
// //   ) {
// //     saveProgress();  // ✅ Only save when something is completed
// //   }
// // }, [completed]);  // ✅ runs only when user marks content as completed

// //         ModuleProgress saved = repository.save(existing);
// //         return ResponseEntity.ok(saved);
// //     }

// @PostMapping
// public ResponseEntity<?> saveProgress(@RequestBody Map<String, Object> request) {
//     try {
//         System.out.println("Incoming Progress Request: " + request);

//         Long userId = Long.valueOf(((Map<String, Object>) request.get("user")).get("id").toString());
//         Long moduleId = Long.valueOf(((Map<String, Object>) request.get("module")).get("id").toString());

//         Optional<User> userOpt = userRepository.findById(userId);
//         Optional<Module> moduleOpt = moduleRepository.findById(moduleId);

//         if (userOpt.isEmpty() || moduleOpt.isEmpty()) {
//             return ResponseEntity.badRequest().body("User or Module not found");
//         }

//         ModuleProgress progress = repository.findByUserAndModule(userOpt.get(), moduleOpt.get())
//                 .orElseGet(() -> {
//                     ModuleProgress newProgress = new ModuleProgress();
//                     newProgress.setUser(userOpt.get());
//                     newProgress.setModule(moduleOpt.get());
//                     return newProgress;
//                 });

//         // Safely handle all optional fields
//         List<Long> readingMaterial = request.containsKey("readingMaterial")
//                 ? ((List<?>) request.get("readingMaterial")).stream().map(val -> Long.parseLong(val.toString())).toList()
//                 : List.of();

//         List<Long> video = request.containsKey("video")
//                 ? ((List<?>) request.get("video")).stream().map(val -> Long.parseLong(val.toString())).toList()
//                 : List.of();

//         List<Long> assignment = request.containsKey("assignment")
//                 ? ((List<?>) request.get("assignment")).stream().map(val -> Long.parseLong(val.toString())).toList()
//                 : List.of();

//         boolean quiz = request.containsKey("quiz") && Boolean.TRUE.equals(request.get("quiz"));

//         // Set all progress values
//        progress.setReadingMaterial(new ArrayList<>(readingMaterial));
// progress.setVideo(new ArrayList<>(video)); // ✅ CORRECT

// progress.setAssignment(new ArrayList<>(assignment));

//         progress.setQuiz(quiz);

//         repository.save(progress);
//         return ResponseEntity.ok("Progress saved");

//     } catch (Exception e) {
//         e.printStackTrace(); // 🔥 see the exact cause in console
//         return ResponseEntity.status(500).body("Failed to save progress: " + e.getMessage());
//     }
// }

//     @GetMapping("/{userId}/{moduleId}")
//     public ResponseEntity<ModuleProgress> getProgress(@PathVariable Long userId, @PathVariable Long moduleId) {
//         Optional<User> userOpt = userRepository.findById(userId);
//         Optional<Module> moduleOpt = moduleRepository.findById(moduleId);

//         if (userOpt.isEmpty() || moduleOpt.isEmpty()) {
//             return ResponseEntity.notFound().build();
//         }

//         Optional<ModuleProgress> progress = repository.findByUserAndModule(userOpt.get(), moduleOpt.get());
//         return progress.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//     }

//     @GetMapping("/course/{userId}/{courseId}")
//     public ResponseEntity<Double> getCourseProgress(@PathVariable Long userId, @PathVariable Long courseId) {
//         Optional<User> userOpt = userRepository.findById(userId);
//         if (userOpt.isEmpty()) {
//             return ResponseEntity.badRequest().body(0.0);
//         }

//         List<Module> modules = moduleRepository.findByCourseId(courseId);
//         double total = 0;

//         for (Module module : modules) {
//             Optional<ModuleProgress> progressOpt = repository.findByUserAndModule(userOpt.get(), module);
//             if (progressOpt.isPresent()) {
//                 ModuleProgress progress = progressOpt.get();
//                 double moduleScore = 0;
//                 if (!progress.getReadingMaterial().isEmpty()) moduleScore += 25;
//                 if (!progress.getVideo().isEmpty()) moduleScore += 25;
//                 if (!progress.getAssignment().isEmpty()) moduleScore += 25;
//                 if (progress.isQuiz()) moduleScore += 25;
//                 total += moduleScore;
//             }
//         }

//         double average = modules.isEmpty() ? 0.0 : total / modules.size();
//         return ResponseEntity.ok(average);
//     }
// }
package com.seminarroom.edu.controller;

import com.seminarroom.edu.model.ModuleProgress;
import com.seminarroom.edu.repository.ModuleProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/progress")
public class ModuleProgressController {

    @Autowired
    private ModuleProgressRepository repository;

    @PostMapping
    public ResponseEntity<ModuleProgress> saveProgress(@RequestBody ModuleProgress progress) {
        Optional<ModuleProgress> existing = repository.findByUserIdAndModuleId(progress.getUserId(), progress.getModuleId());

        ModuleProgress toSave = existing.map(existingProgress -> {
            existingProgress.setReadingMaterial(progress.isReadingMaterial());
            existingProgress.setVideo(progress.isVideo());
            existingProgress.setAssignment(progress.isAssignment());
            existingProgress.setQuiz(progress.isQuiz());
            return existingProgress;
        }).orElse(progress);

        return ResponseEntity.ok(repository.save(toSave));
    }

    @GetMapping("/{userId}/{moduleId}")
    public ResponseEntity<ModuleProgress> getProgress(@PathVariable Long userId, @PathVariable Long moduleId) {
        return repository.findByUserIdAndModuleId(userId, moduleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}