package com.studyapi.qaTest.repository;

import com.studyapi.qaTest.entities.QaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class QaRepository {
    private List<QaEntity> qaEntities = new ArrayList<>();

    public List<QaEntity> getAllQaEntities() {
        return qaEntities;
    }

    public QaEntity createQaEntity(QaEntity qaEntity) {
        qaEntity.setId((int) (qaEntities.size() + 1)); // Atribua um ID único
        qaEntities.add(qaEntity);
        return qaEntity;
    }

    public void deleteQaEntity(Integer id) {
        qaEntities.removeIf(entity -> Objects.equals(entity.getId(), id));
    }
}
