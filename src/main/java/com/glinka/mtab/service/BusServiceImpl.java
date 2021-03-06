package com.glinka.mtab.service;

import com.glinka.mtab.model.Agency;
import com.glinka.mtab.model.Bus;
import com.glinka.mtab.repository.BusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService{

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Override
    public List<Bus> findAllByAgency(Agency agency) {
        return busRepository.findAllByAgency(agency);
    }

    @Override
    public Bus findById(Long id) {
        return busRepository.findById(id).orElse(null);
    }

    @Override
    public Bus save(Bus bus) {
        return busRepository.saveAndFlush(bus);
    }

    @Override
    public boolean deleteById(Long id) {
        if(!busRepository.existsById(id))
        return false;

        busRepository.deleteById(id);
        return true;
    }
}
