package com.example.demo.services;

import com.example.demo.entity.Subgerente;
import com.example.demo.repository.SubGerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author mijae
 */
@Service
public class SubGerenteService implements Operaciones<Subgerente> {

    @Autowired
    private SubGerenteRepository subgerenteRepository;

    @Override
    public Subgerente create(Subgerente t) {
        return subgerenteRepository.save(t);
    }

    @Override
    public Subgerente update(Subgerente t) {
        return subgerenteRepository.save(t);
    }

    @Override
    public void delete(int id) {
        subgerenteRepository.deleteById(id);
    }

    @Override
    public Subgerente read(int id) {
        return subgerenteRepository.findById(id).get();
    }

    @Override
    public List<Subgerente> readAll() {
        return subgerenteRepository.findAll();
    }

}
