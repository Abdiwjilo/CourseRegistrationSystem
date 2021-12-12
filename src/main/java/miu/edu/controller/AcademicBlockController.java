package miu.edu.controller;

import miu.edu.dto.AcademicBlockDto;
import miu.edu.model.AcademicBlock;
import miu.edu.repository.AcademicBlockRepository;
import miu.edu.service.Implementation.AcademicBlockServiceImpl;
import miu.edu.util.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcademicBlockController {

    @Autowired
    AcademicBlockRepository academicBlockRepository;
    @Autowired
    AcademicBlockServiceImpl academicBlockService;



    @GetMapping(value = "/academicblocks")
    public List<AcademicBlock> findAll() {
        return academicBlockService.findAll();
    }

    @GetMapping(value = "/academicblocks", params = "paged=true")
    public ResponseEntity<?> findAll(Pageable pageable) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, academicBlockService.findAll(pageable));
    }

    @GetMapping("/academicblocks/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseHandler
                .respond("Success", HttpStatus.OK, academicBlockService.findById(id));
    }

    @PostMapping("/academicblocks")
    public ResponseEntity<?> addAcademicBlock(@RequestBody AcademicBlockDto academicBlockDto) {
        AcademicBlock academicBlock = academicBlockService.addAcademicBlock(academicBlockDto);
        if (academicBlock!= null) {
            return ResponseHandler.respond("Successfully added a academicBlock !", HttpStatus.OK, academicBlock);
        } else {
            return ResponseHandler.respond("Null entities found", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("academicblocks/{id}")
    public ResponseEntity<?> deleteAcademicBlock(@PathVariable Long id) {
        academicBlockService.removeAcademicBlock(id);
        return ResponseHandler.respond("Successfully deleted a academicBlock!", HttpStatus.ACCEPTED);
    }
    @DeleteMapping("academicblocks")
    public ResponseEntity<?> deleteAcademicBlocks() {
        academicBlockService.removeAcademicBlocks();
        return ResponseHandler.respond("Successfully deleted a academicblocks!", HttpStatus.ACCEPTED);
    }
    }
