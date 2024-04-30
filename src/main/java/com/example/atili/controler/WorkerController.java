package com.example.atili.controler;

import com.example.atili.entity.Worker;
import com.example.atili.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("")
    public List<Worker> getAllWorkers() {
        return workerService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        Optional<Worker> worker = workerService.getWorkerById(id);
        return worker.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
        Worker createdWorker = workerService.saveWorker(worker);
        return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return ResponseEntity.noContent().build();
    }

    // Optional<Worker> findWorkerByEmail(@RequestParam String email) {
    //     return workerService.findWorkerByEmail(email);
    // }
}

