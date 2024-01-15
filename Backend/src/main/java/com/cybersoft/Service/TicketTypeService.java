package com.cybersoft.Service;

import com.cybersoft.Entity.TicketType;
import com.cybersoft.Repository.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketTypeService {

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    public List<TicketType> getAllTicketTypes() {
        return ticketTypeRepository.findAll();
    }
}
