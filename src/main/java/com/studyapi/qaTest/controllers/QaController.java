package com.studyapi.qaTest.controllers;

import com.studyapi.qaTest.entities.QaEntity;
import com.studyapi.qaTest.services.QaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/qa")
public class QaController {
    private final QaService qaService;

    @Autowired
    public QaController(QaService qaService) {
        this.qaService = qaService;
    }

    @GetMapping
    public List<QaEntity> getObjects() {
        return qaService.getAllQaEntities();
    }

    @PostMapping
    public QaEntity createObject(@RequestBody QaEntity qaEntity) {
        return qaService.createQaEntity(qaEntity);
    }
    @PutMapping("/{id}")
    public QaEntity updateObject(@PathVariable Integer id, @RequestBody QaEntity qaEntity) {
        return qaService.updateQaEntity(id, qaEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteObject(@PathVariable Integer id) {
        qaService.deleteQaEntity(id);
    }

}
