package com.studyapi.qaTest.services;

import com.studyapi.qaTest.entities.QaEntity;
import com.studyapi.qaTest.repository.QaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class QaService {
    private final QaRepository qaRepository;

    @Autowired
    public QaService(QaRepository qaRepository) {
        this.qaRepository = qaRepository;
    }

    public List<QaEntity> getAllQaEntities() {
        return qaRepository.getAllQaEntities();
    }

    public QaEntity createQaEntity(QaEntity qaEntity) {
        return qaRepository.createQaEntity(qaEntity);
    }

    public QaEntity updateQaEntity(Integer id, QaEntity qaEntity) {
        for (QaEntity existingEntity : qaRepository.getAllQaEntities()) {
            if (Objects.equals(existingEntity.getId(), id)) {
                existingEntity.setName(qaEntity.getName());
                existingEntity.setCountry(qaEntity.getCountry());
                return existingEntity;
            }
        }
        return null; // Retorne null se o objeto com o ID especificado não for encontrado
    }

    public void deleteQaEntity(Integer id) {
        qaRepository.deleteQaEntity(id);
    }

}
