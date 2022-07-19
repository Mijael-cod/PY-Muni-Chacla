package com.example.demo.services;

import com.example.demo.entity.Junta;
import com.example.demo.repository.JuntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author mijae
 */
@Service
public class JuntaService implements Operaciones<Junta> {

    @Autowired
    private JuntaRepository juntaRepository;

    @Override
    public Junta create(Junta t) {
        return juntaRepository.save(t);

    }

    @Override
    public Junta update(Junta t) {
        return juntaRepository.save(t);
    }

    @Override
    public void delete(int id) {
        juntaRepository.deleteById(id);
    }

    @Override
    public Junta read(int id) {
        return juntaRepository.findById(id).get();
    }

    @Override
    public List<Junta> readAll() {
        return juntaRepository.findAll();
    }

}
