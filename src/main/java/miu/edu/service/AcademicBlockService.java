package miu.edu.service;

import miu.edu.dto.AcademicBlockDto;
import miu.edu.model.AcademicBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AcademicBlockService {
    List<AcademicBlock> findAll();
    Page<AcademicBlock> findAll(Pageable pageable);
    AcademicBlock findById(Long id);
    AcademicBlock addAcademicBlock(AcademicBlockDto academicBlockDto);
    void removeAcademicBlock(Long id);
    void removeAcademicBlocks();
    AcademicBlock updateAcademicBlock(Long id, AcademicBlockDto academicBlockDto);
}
