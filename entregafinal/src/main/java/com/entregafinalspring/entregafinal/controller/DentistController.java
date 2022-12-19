package com.entregafinalspring.entregafinal.controller;

import com.entregafinalspring.entregafinal.dto.DentistDTO;
import com.entregafinalspring.entregafinal.entity.Dentist;
//import com.entregafinalspring.entregafinal.services.DentistService;
import com.entregafinalspring.entregafinal.services.DentistService;
import com.entregafinalspring.entregafinal.services.DentistServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/dentist") // Base URL
public class DentistController {

//    private final DentistService dentistService;
    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

//    // POST MAPPING
//    //@RequestMapping(value = "/crear", method = RequestMethod.POST) // Esto seria sin usar Spring
    @PostMapping("/new")
    public ResponseEntity<String> createDentistHandler(@RequestBody Dentist dentist) {
        ResponseEntity<String> response;

        if (Objects.nonNull(dentistService.createDentist(dentist))) {
            response = ResponseEntity.ok("El ondontologo fue creado con exito.! \n" + dentist);
        } else {
            response = ResponseEntity.internalServerError().body("Algo ha salido mal...!!");
        }
        return response;
    }

//    // POST MAPPING
//    //@RequestMapping(value = "/crear", method = RequestMethod.POST) // Esto seria sin usar Spring
//    @PostMapping("/new") // Es una abreviacion de Spring
//    public ResponseEntity<DentistDTO> createDentistHandler(@RequestBody Dentist dentist) throws SQLException {
//        DentistDTO dentistDTO = dentistService.createDentist(dentist).orElse(null);
//        return ResponseEntity.ok(dentistDTO);
//    }

//    // GET MAPPING
////    @GetMapping("/{id}}") Usando @PathVariable
    @GetMapping("/search")
    public ResponseEntity<DentistDTO> searchDentistHandler(@RequestParam int id) {
        DentistDTO dentistDTO = dentistService.searchDentist(id).orElse(null);
        return ResponseEntity.ok(dentistDTO);
    }


//    // GET MAPPING
////    @GetMapping("/{id}}") Usando @PathVariable
//    @GetMapping("/search")
//    public ResponseEntity<DentistDTO> searchDentistHandler(@RequestParam int id) {
//        // .orElse de libreria Optional
//        DentistDTO dentistDTO = dentistService.searchDentist(id).orElse(null);
//        return ResponseEntity.ok(dentistDTO);
//    }

    @GetMapping("/list")
    public ResponseEntity<List<Optional<DentistDTO>>> searchAllDentistHandler() {
        List<Optional<DentistDTO>> dentistDTOList = dentistService.searchAllDentist();
        return ResponseEntity.ok(dentistDTOList);
    }

//    // GET ALL
//    @GetMapping("/list")
//    public ResponseEntity<List<Optional<DentistDTO>>> searchAllDentistHandler() {
//        List<Optional<DentistDTO>> dentistDTOList = dentistService.searchAllDentist();
//        return ResponseEntity.ok(dentistDTOList);
//    }

//    // PUT MAPPING
    @PutMapping
    public ResponseEntity<DentistDTO> updateDentistHandler(@RequestBody Dentist dentist) {
        return null;
    }


//    // PUT MAPPING
//    @PutMapping()
//    public ResponseEntity<DentistDTO> updateDentistHandler(@RequestBody Dentist dentist) {
//        DentistDTO dentistDTO = dentistService.updateDentist(dentist).orElse(null);
//        return ResponseEntity.ok(dentistDTO);
//    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public void deleteDentistHandler(@PathVariable int id) {
       dentistService.deleteDentist(id);
    }

//    // DELETE MAPPING
//    @DeleteMapping("/{id}")
//    public void deleteDentistHandler(@PathVariable int id) {
//        dentistService.deleteDentist(id);
//    }

}
