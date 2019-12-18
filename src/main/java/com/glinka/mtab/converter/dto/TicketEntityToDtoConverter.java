package com.glinka.mtab.converter.dto;

import com.glinka.mtab.converter.ConverterAdapter;
import com.glinka.mtab.dto.TicketDto;
import com.glinka.mtab.model.entity.Ticket;
import com.glinka.mtab.model.entity.TripSchedule;
import com.glinka.mtab.service.TripScheduleService;
import com.glinka.mtab.service.UserService;

public class TicketEntityToDtoConverter extends ConverterAdapter<Ticket, TicketDto> {

    private final UserService userService;
    private final TripScheduleService tripScheduleService;

    public TicketEntityToDtoConverter(UserService userService, TripScheduleService tripScheduleService) {
        this.userService = userService;
        this.tripScheduleService = tripScheduleService;
    }

    @Override
    public Ticket convert(Ticket target, TicketDto source) {
        if(target == null || source == null)
           return null;

        target.setId(source.getId());
        target.setCancellable(source.getCancellable());
        target.setJourneyDate(source.getJourneyDate());
        target.setPassenger(userService.findById(source.getId()));
        target.setTripSchedule(tripScheduleService.findById(source.getTripscheduleId()));

        return target;
    }
}
