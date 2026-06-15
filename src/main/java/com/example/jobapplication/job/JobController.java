package com.example.jobapplication.job;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody JobWithCompanyName jobWithCompanyName){
        jobService.createJob(jobWithCompanyName);
        return new ResponseEntity<>("Jobs Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable String id){
        Job job = jobService.getJobById(id);
        if(job!= null){
            return new ResponseEntity<>(job,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable String id) {
        boolean delete = jobService.deleteJob(id);
        if(delete){
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("job with id not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJob(@PathVariable String id, @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if(updated) return new ResponseEntity<>("Successfully Updated",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}
