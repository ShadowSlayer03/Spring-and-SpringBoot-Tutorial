package com.arjun.app.Service;

import com.arjun.app.Repository.LaptopRepository;
import com.arjun.app.Model.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap){
        repo.save(lap);
    }

    public boolean isGamingLaptop(Laptop lap){
        return lap.getGraphicsCardVersion() > 1650;
    }
}
