package tn.esprit.pidev.serviceImpl;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.pidev.entity.*;
import tn.esprit.pidev.repository.AffectationRequestRepository;
import tn.esprit.pidev.repository.TaskRepository;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.pidev.entity.*;
import tn.esprit.pidev.repository.AffectationRequestRepository;
import tn.esprit.pidev.repository.TaskRepository;
import tn.esprit.pidev.repository.UserRepository;
import tn.esprit.pidev.serviceIterface.ITaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    AffectationRequestRepository affectationRequestRepository;
private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository ) {
        this.taskRepository = taskRepository;
    }


    @Autowired
    UserRepository userRepository;
    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> retriveAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task retriveTask(Long idTask) {
        return taskRepository.findById(idTask).get();
    }
    public List<AffectationRequest> getAffectationRequests() {
        return affectationRequestRepository.findAll();
    }

    @Override
    public void removeTask(Long idTask) {
          taskRepository.deleteById(idTask);
    }

    @Override

    public Task affecterTaskATask(Long idUser, Long idTask) {
        Task task = taskRepository.findById(idTask).orElse(null);
        User user = userRepository.findById(idUser).orElse(null);

        if (task != null && user != null) {
            task.setOrganizer(user);
            taskRepository.save(task);

            // Créez une demande d'affectation
            AffectationRequest affectationRequest = new AffectationRequest();
            affectationRequest.setUser(user);
            affectationRequest.setTask(task);
            affectationRequest.setStatus("PENDING"); // En attente d'acceptation

            affectationRequestRepository.save(affectationRequest);

            return task;
        }

        return null; // Gérer le cas où la tâche ou l'utilisateur n'est pas trouvé
    }

    public void acceptAffectationRequest(Long requestId) {
        Optional<AffectationRequest> optionalRequest = affectationRequestRepository.findById(requestId);

        if (optionalRequest.isPresent()) {
            AffectationRequest request = optionalRequest.get();

            // Appliquer la logique d'acceptation
            request.setStatus("ACCEPTED");

            // Autres actions d'acceptation si nécessaire

            // Enregistrez les modifications dans la base de données
            affectationRequestRepository.save(request);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Demande d'affectation non trouvée avec l'ID : " + requestId);
        }
    }

    public void rejectAffectationRequest(Long requestId) {
        Optional<AffectationRequest> optionalRequest = affectationRequestRepository.findById(requestId);

        if (optionalRequest.isPresent()) {
            AffectationRequest request = optionalRequest.get();

            // Appliquer la logique de refus
            request.setStatus("REJECTED");

            // Autres actions de refus si nécessaire

            // Enregistrez les modifications dans la base de données
            affectationRequestRepository.save(request);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Demande d'affectation non trouvée avec l'ID : " + requestId);
        }
    }}