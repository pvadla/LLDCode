package com.scaler.bmsfair.repositories;

import com.scaler.bmsfair.exceptions.ShowSeatNotAvailableException;
import com.scaler.bmsfair.models.Show;
import com.scaler.bmsfair.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    ShowSeat save(ShowSeat showSeat);

}
