package com.wajahat.springfield.data.repository;

import com.wajahat.springfield.data.domain.Guest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Class Repository Class for {@link Guest}
 * Created by wajahat
 */
@Repository
public interface GuestRepository extends PagingAndSortingRepository<Guest, Long> {
}
