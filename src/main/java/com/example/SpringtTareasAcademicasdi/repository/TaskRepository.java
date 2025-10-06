package com.example.SpringtTareasAcademicasdi.repository;

import com.example.SpringtTareasAcademicasdi.entities.Task;

import java.util.*;

public class TaskRepository {

    private List<Task> tareas = new ArrayList<>();
    long idSiguiente=0;
    public Task guardar(Task task){
        if (task.getId()== null){
            idSiguiente++;
            task.setId(idSiguiente);
            task.setId(idSiguiente);
            tareas.add(task);
            return task;
        }
        return task;
    }

    public List<Task> findAll(){
        return tareas;
    }

    public Optional<Task> findById(Long id){
        return tareas.stream().filter(task -> task.getId().equals(id)).findFirst();
    }


}
