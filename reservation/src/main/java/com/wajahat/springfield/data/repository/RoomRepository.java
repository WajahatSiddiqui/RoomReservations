package com.wajahat.springfield.data.repository;

import com.wajahat.springfield.data.domain.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * {@link CrudRepository} for {@link Room}
 */
@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByNumber(String number);
}
