package miu.edu.controller;

import miu.edu.model.AcademicBlock;
import miu.edu.repository.AcademicBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class AcademicBlockController {

        @Autowired
        AcademicBlockRepository academicblockRepository;

        @GetMapping("/academicblocks")
        public ResponseEntity<List<AcademicBlock>> getAllAcademicBlocks(@RequestParam(required = false) String code) {
            try {
                List<AcademicBlock> academicblocks = new ArrayList<AcademicBlock>();

                if (code == null)
                    academicblockRepository.findAll().forEach(academicblocks::add);
                else
                    academicblockRepository.findByCode(code).forEach(academicblocks::add);

                if (academicblocks.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(academicblocks, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        @GetMapping("/academicblock/{id}")
        public ResponseEntity<AcademicBlock> getAcademicBlockById(@PathVariable("id") long id){
            Optional<AcademicBlock> academicblockData = academicblockRepository.findById(id);
            if (academicblockData.isPresent()){
                return new ResponseEntity<>(academicblockData.get(), HttpStatus.OK);
            } else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


        @PostMapping("/academicblocks")
        public ResponseEntity<AcademicBlock> createAcademicBlock(@RequestBody AcademicBlock academicblock) {
            try {
                AcademicBlock _academicblock = academicblockRepository
                        .save(new AcademicBlock(academicblock.getCode(), academicblock.getName(),  academicblock.getSemester(), academicblock.getStartDate(), academicblock.getEndDate()));
                return new ResponseEntity<>(_academicblock, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PutMapping("/academicblocks/{id}")
        public ResponseEntity<AcademicBlock> updateAcademicBlock(@PathVariable("id") long id, @RequestBody AcademicBlock academicblock) {
            Optional<AcademicBlock> academicblockData = academicblockRepository.findById(id);

            if (academicblockData.isPresent()) {
                AcademicBlock _academicblock = academicblockData.get();
                _academicblock.setCode(academicblock.getCode());
                _academicblock.setName(academicblock.getName());
                _academicblock.setSemester(academicblock.getSemester());
                _academicblock.setStartDate(academicblock.getStartDate());
                _academicblock.setEndDate(academicblock.getEndDate());
                return new ResponseEntity<>(academicblockRepository.save(_academicblock), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @DeleteMapping("/academicblocks/{id}")
        public ResponseEntity<HttpStatus> deleteAcademicBlock(@PathVariable("id") long id) {
            try {
                academicblockRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("/academicblocks")
        public ResponseEntity<HttpStatus> deleteAllAcademicBlock() {
            try {
                academicblockRepository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
