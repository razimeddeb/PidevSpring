package tn.esprit.pidev.serviceIterface;

import tn.esprit.pidev.entity.Task;

import java.util.List;
public interface ITaskService {
    Task addTask(Task task);

    List<Task> retriveAllTasks();

    Task updateTask(Task task);

    /*  List<AffectationRequest> getAffectationRequests() ;*/
    Task retriveTask(Long idTask);

    void removeTask(Long idTask);

  /*  public Task affecterTaskATask(Long idUser, Long idTask) ;
   /* public void acceptAffectationRequest(Long requestId) ;
   /* public void rejectAffectationRequest(Long requestId) ;
   void affecterTaskAUser(Long idUser, Long idTask) ;}*/
   String affecterTaskAUser(Long idUser, Long idTask) ;

}