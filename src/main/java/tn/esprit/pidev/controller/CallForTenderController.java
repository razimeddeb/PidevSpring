package tn.esprit.pidev.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pidev.entity.CallForTender;
import tn.esprit.pidev.serviceIterface.ICallForTenderService;

import java.util.List;

@RestController
@RequestMapping("/callfortenders")
@AllArgsConstructor
public class CallForTenderController {
    private final ICallForTenderService callForTenderService;

    @PostMapping("add-a-call")
    public ResponseEntity<CallForTender> addCallForTender(@RequestBody @Valid CallForTender callForTender) {
        CallForTender addedCallForTender = callForTenderService.addCallForTender(callForTender);
        return new ResponseEntity<>(addedCallForTender, HttpStatus.CREATED);
    }

    @GetMapping("list-all-calls")
    public ResponseEntity<List<CallForTender>> getAllCallForTenders() {
        List<CallForTender> allCallForTenders = callForTenderService.retriveAllCallForTender();
        return new ResponseEntity<>(allCallForTenders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CallForTender>> getCallForTenderById(@PathVariable("id") Long id) {
        List<CallForTender> callForTenders = callForTenderService.retriveCallForTender(id);
        return new ResponseEntity<>(callForTenders, callForTenders.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CallForTender> updateCallForTender(@PathVariable("id") Long id,
                                                             @RequestBody @Valid CallForTender callForTender) {
        List<CallForTender> existingCallForTender = callForTenderService.retriveCallForTender(id);
        if (existingCallForTender.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        callForTender.setIdCOT(id);
        CallForTender updatedCallForTender = callForTenderService.updateCallForTender(callForTender);
        return new ResponseEntity<>(updatedCallForTender, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCallForTender(@PathVariable("id") Long id) {
        List<CallForTender> existingCallForTender = callForTenderService.retriveCallForTender(id);
        if (existingCallForTender.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        callForTenderService.removeCallForTender(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public List<String> search(@RequestParam("query") String query) {
        // Perform the search based on the query parameter
        // and return the results as a list of strings
        return callForTenderService.search(query);
    }
}


