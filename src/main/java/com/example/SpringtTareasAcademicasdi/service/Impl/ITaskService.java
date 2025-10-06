package com.example.SpringtTareasAcademicasdi.service.Impl;

import com.example.SpringtTareasAcademicasdi.entities.Task;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.*;

public interface ITaskService {
    List<Task> findAll();
    Optional<Task> findById(Long id);
    Task crear (String nombre, String correo, String titulo, String descripcion, Date fecha_entrega, String estado);
    Task cambiarEstado(Long id, String estado);

}
