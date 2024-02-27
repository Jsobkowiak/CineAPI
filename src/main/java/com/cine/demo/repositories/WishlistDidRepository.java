package com.cine.demo.repositories;

import com.cine.demo.entities.cineScape.WishlistDid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistDidRepository extends JpaRepository<WishlistDid, Long> {
}