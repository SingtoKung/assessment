package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.user_ticket.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface LotteryRepository extends JpaRepository<Lottery, String> {

    Optional<Lottery> findByTicket(String ticket);

    @Modifying
    @Query(value = "SELECT * FROM lottery l WHERE l.amount > 0 ORDER BY id", nativeQuery = true)
    List<Lottery> findByAllAvailableTicket();

    @Modifying
    @Query(value = "SELECT * FROM lottery l ORDER BY id", nativeQuery = true)
    List<Lottery> findByOwnerTicket();

}
