package miu.edu.service.Implementation;

import miu.edu.dto.AcademicBlockDto;

import miu.edu.model.AcademicBlock;
import miu.edu.repository.AcademicBlockRepository;
import miu.edu.service.AcademicBlockService;
import miu.edu.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AcademicBlockServiceImpl implements AcademicBlockService {
    @Autowired
    private AcademicBlockRepository academicBlockRepository;

    @Override
    public List<AcademicBlock> findAll() {
        return academicBlockRepository.findAll();
    }

    @Override
    public Page<AcademicBlock> findAll(Pageable pageable) {
        return academicBlockRepository.findAll(pageable);
    }

    @Override
    public AcademicBlock findById(Long id) {
        return academicBlockRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AcademicBlock with id " + id + " not found"));
    }


    @Override
    public void removeAcademicBlock(Long id) {
        AcademicBlock academicBlock = academicBlockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AcademicBlock with id " + id + " not found for deletion"));

        academicBlockRepository.delete(academicBlock);
    }

    @Override
    public void removeAcademicBlocks() {
        academicBlockRepository.deleteAll();
    }

    @Override
    public  AcademicBlock updateAcademicBlock(Long id, AcademicBlockDto academicBlockDto){
        AcademicBlock academicBlock = academicBlockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AcademicBlock with id" + id + " not found for update"));

        academicBlock.setCode(academicBlockDto.getCode());
        academicBlock.setName(academicBlockDto.getName());
        academicBlock.setSemester(academicBlockDto.getSemester());
        academicBlock.setStartDate(academicBlockDto.getStartDate());
        academicBlock.setEndDate(academicBlockDto.getEndDate());
        academicBlockRepository.flush();
        return academicBlock;
    }


    @Override
    public AcademicBlock addAcademicBlock(AcademicBlockDto academicBlockDto) {
        AcademicBlock academicBlock = new AcademicBlock();
        academicBlock.setCode(academicBlockDto.getCode());
        academicBlock.setName(academicBlockDto.getName());
        academicBlock.setSemester(academicBlockDto.getSemester());
        academicBlock.setStartDate(academicBlockDto.getStartDate());
        academicBlock.setEndDate(academicBlockDto.getEndDate());
        return academicBlockRepository.save(academicBlock);
    }
}
