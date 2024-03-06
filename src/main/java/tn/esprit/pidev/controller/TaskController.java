package tn.esprit.pidev.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.*;
import tn.esprit.pidev.repository.TaskRepository;
import tn.esprit.pidev.serviceImpl.TaskService;
import tn.esprit.pidev.serviceIterface.IPackService;

import java.util.List;
@CrossOrigin(origins = "*") // Ajoutez votre domaine Angular ici

@AllArgsConstructor
@RestController
@RequestMapping("back/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom("cyrine.mezzi@esprit.tn");
            mail.setTo(emailRequest.getTo());
            mail.setSubject(emailRequest.getSubject());
            mail.setText(emailRequest.getBody());

            javaMailSender.send(mail);

            return ResponseEntity.ok("Email envoyé avec succès!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'envoi de l'e-mail : " + e.getMessage());
        }}
    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }


    @GetMapping("/getAllTask")
    public List<Task> retriveAllTasks() {
        return taskService.retriveAllTasks();
    }
    @PutMapping("/UpdateTask")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
    @GetMapping("/retriveTask/{id_Task}")
    public Task retriveTask(@PathVariable("id_Task") Long idTask) {
        return taskService.retriveTask(idTask);
    }
    @DeleteMapping("/removeTask/{id_Task}")
    public void removeTask(@PathVariable("id_Task") Long idTask) {
        taskService.removeTask(idTask);
    }

      /*  @PostMapping("/affecterTaskATask/{idUser}/{idTask}")
        public  Task affecterTaskATask(@PathVariable("idUser") Long idUser,@PathVariable("idTask") Long idTask ){
            return taskService.affecterTaskATask(idUser, idTask );
        }*/


  /*  @PostMapping("/accept/{requestId}")
    public ResponseEntity<?> acceptAffectationRequest(@PathVariable Long requestId) {
        try {
            taskService.acceptAffectationRequest(requestId);
            return ResponseEntity.ok("Demande d'affectation acceptée avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'acceptation de la demande d'affectation.");
        }
    }

    @PostMapping("/reject/{requestId}")
    public ResponseEntity<?> rejectAffectationRequest(@PathVariable Long requestId) {
        try {
            taskService.rejectAffectationRequest(requestId);
            return ResponseEntity.ok("Demande d'affectation refusée avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors du refus de la demande d'affectation.");
        }
    }


*/

}
