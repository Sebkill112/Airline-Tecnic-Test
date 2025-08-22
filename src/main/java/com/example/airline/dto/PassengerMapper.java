package com.example.airline.dto;

import org.springframework.stereotype.Component;

import com.example.airline.entity.BoardingPass;

@Component
public class PassengerMapper {
	
	public PassengerInfo toPassengerInfo(BoardingPass boardingPass) {
        if (boardingPass == null) {
            return null;
        }

        PassengerInfo passengerInfo = new PassengerInfo();
        passengerInfo.setPassengerId(boardingPass.getPassengerId());
        
        if (boardingPass.getPassenger() != null) {
            passengerInfo.setDni(boardingPass.getPassenger().getDni());
            passengerInfo.setName(boardingPass.getPassenger().getName());
            passengerInfo.setAge(boardingPass.getPassenger().getAge());
            passengerInfo.setCountry(boardingPass.getPassenger().getCountry());
        } else {

            passengerInfo.setDni(null);
            passengerInfo.setName(null);
            passengerInfo.setAge(null);
            passengerInfo.setCountry(null);
        }
        
        passengerInfo.setBoardingPassId(boardingPass.getBoardingPassId());
        passengerInfo.setPurchaseId(boardingPass.getPurchaseId());
        passengerInfo.setSeatTypeId(boardingPass.getSeatTypeId());
        passengerInfo.setSeatId(boardingPass.getSeatId());
        
        return passengerInfo;
    }

}
