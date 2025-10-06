package com.example.SpringtTareasAcademicasdi.service;

import com.example.SpringtTareasAcademicasdi.entities.Task;
import com.example.SpringtTareasAcademicasdi.repository.TaskRepository;
import com.example.SpringtTareasAcademicasdi.service.Impl.ITaskService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public Task crear(String nombre, String correo, String titulo, String descripcion, Date fecha_entrega, String estado) {
        Task task = new Task();
        task.setNombre(nombre);
        task.setCorreo(correo);
        task.setTitulo(titulo);
        task.setDescripcion(descripcion);
        task.setFecha_entrega(fecha_entrega);
        task.setEstado(estado);
        return taskRepository.guardar(task);
    }

    @Override
    public Task cambiarEstado(Long id, String estado) {
        Optional<Task> cambiar =findById(id);
        if (cambiar.isPresent()){
            Task task = cambiar.get();
            if (task.getEstado() == null){
                System.out.println("Error de compilacion");
            }
            else {
                task.setEstado(estado);
            }
            return task;
        }

        return null;
    }


}
