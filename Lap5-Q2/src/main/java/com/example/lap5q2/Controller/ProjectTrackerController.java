package com.example.lap5q2.Controller;

import com.example.lap5q2.Api.ApiRespons;
import com.example.lap5q2.Model.ProjectTracker;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/Project")
public class ProjectTrackerController {

    ArrayList<ProjectTracker> projects = new ArrayList<>();


    @GetMapping("/getProjects")
    public ArrayList<ProjectTracker> getProjects() {
        return projects;
    }

    @PostMapping("/addProject")
    public ApiRespons addProjects(@RequestBody ProjectTracker project) {
        projects.add(project);
        return new ApiRespons("Project added");
    }

    @PutMapping("/update/{index}")
    public  ApiRespons updatedProjects(@PathVariable int index, @RequestBody ProjectTracker project) {
        projects.set(index, project);
        return new  ApiRespons(" Project updated ");
    }

    @DeleteMapping("/delete/{index}")
    public  ApiRespons deletedProjects(@PathVariable int index) {
        projects.remove(index);
        return  new ApiRespons("Project Deleted");
    }

    @PutMapping("/updateStatus/{index}")
    public  ApiRespons updatedStatus(@PathVariable int index) {
        if(projects.get(index).getStatus().equalsIgnoreCase("not done")){
            projects.get(index).setStatus("done");
            return new  ApiRespons(" Status updated ");
        }
        return new  ApiRespons(" Status not updated ");
    }

    @GetMapping("/Search/{title}")
    public ApiRespons SearchTitle(@PathVariable String title ){
        for (ProjectTracker P : projects) {
            if (P.getTitle().equalsIgnoreCase(title))
                return new ApiRespons( " title is found "+P);
        }

        return new ApiRespons( " title is not found ");
    }

    @GetMapping("/getCompanyName/{CompanyName}")
    public ApiRespons getCompanyName(@PathVariable String CompanyName ){
        for (ProjectTracker P : projects) {
            if (P.getCompanyName().equalsIgnoreCase(CompanyName))
                return new ApiRespons( " Project: "+P);
        }

        return new ApiRespons( " Company Name is not found ");
    }

}
