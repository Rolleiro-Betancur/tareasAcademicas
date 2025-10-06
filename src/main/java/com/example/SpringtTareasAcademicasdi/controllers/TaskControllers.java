    package com.example.SpringtTareasAcademicasdi.controllers;

    import com.example.SpringtTareasAcademicasdi.entities.Task;
    import com.example.SpringtTareasAcademicasdi.service.Impl.ITaskService;
    import org.springframework.web.bind.annotation.*;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api")
    public class TaskControllers {

        private ITaskService iTaskService;

        public TaskControllers(ITaskService iTaskService){
            this.iTaskService = iTaskService;
        }

        @GetMapping("/lista")
        public List<Task> listaTareas(){
            return iTaskService.findAll();
        }

        @GetMapping("/{id}")
        public Optional<Task> ObtenerId(@PathVariable Long id){
            return iTaskService.findById(id);
        }

        @PostMapping("/crear")
        public Task crear(@RequestParam String nombre, @RequestParam String correo, @RequestParam String titulo, @RequestParam String descripcion, @RequestParam Date fecha_entrega, @RequestParam String estado){
            return iTaskService.crear(nombre,correo,titulo,descripcion,fecha_entrega,estado);
        }

        @PutMapping("/{id}/estado")
        public Task ActualizarEstado(@PathVariable Long id, @RequestParam String estado){
            return iTaskService.cambiarEstado(id,estado);
        }








    }
