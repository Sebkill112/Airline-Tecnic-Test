package com.example.airline.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.airline.entity.BoardingPass;
import com.example.airline.entity.Seat;

@Component
public class SeatAssignmentService {
	
	public void assignSeats(List<BoardingPass> boardingPasses, List<Seat> seats) {
		
        Map<Long, List<Seat>> availableSeats = seats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatTypeId, Collectors.toList()));

        availableSeats.values().forEach(list ->
                list.sort(Comparator.comparing(Seat::getSeatRow)
                        .thenComparing(Seat::getSeatColumn))
        );

        Map<Long, List<BoardingPass>> groups = boardingPasses.stream()
                .collect(Collectors.groupingBy(BoardingPass::getPurchaseId));

        for (List<BoardingPass> group : groups.values()) {
            assignGroupSeats(group, availableSeats);
        }
    }

    private void assignGroupSeats(List<BoardingPass> group, Map<Long, List<Seat>> availableSeats) {
        if (group.isEmpty()) return;

        group.sort((bp1, bp2) -> {
            boolean bp1Minor = bp1.getPassenger().getAge() < 18;
            boolean bp2Minor = bp2.getPassenger().getAge() < 18;
            return Boolean.compare(bp1Minor, bp2Minor); 
        });

        Long seatTypeId = group.get(0).getSeatTypeId();
        List<Seat> seatsOfType = availableSeats.getOrDefault(seatTypeId, new ArrayList<>());

        if (seatsOfType.isEmpty()) return;

        List<Seat> block = findContiguousBlock(seatsOfType, group.size());

        if (block.isEmpty()) {
        	
            Iterator<Seat> it = seatsOfType.iterator();
            for (BoardingPass bp : group) {
                if (!it.hasNext()) break;
                Seat seat = it.next();
                bp.setSeatId(seat.getSeatId());
                it.remove(); 
            }
        } else {
        	
            for (int i = 0; i < group.size(); i++) {
                BoardingPass bp = group.get(i);
                Seat seat = block.get(i);
                bp.setSeatId(seat.getSeatId());
                seatsOfType.remove(seat);
            }
        }
    }

    private List<Seat> findContiguousBlock(List<Seat> seats, int size) {
    	
        Map<Integer, List<Seat>> seatsByRow = seats.stream()
                .collect(Collectors.groupingBy(Seat::getSeatRow));

        for (List<Seat> rowSeats : seatsByRow.values()) {
            rowSeats.sort(Comparator.comparing(Seat::getSeatColumn));
            for (int i = 0; i <= rowSeats.size() - size; i++) {
                List<Seat> candidate = rowSeats.subList(i, i + size);
                if (candidate.size() == size) {
                    return new ArrayList<>(candidate);
                }
            }
        }

        return Collections.emptyList();
    }

}
