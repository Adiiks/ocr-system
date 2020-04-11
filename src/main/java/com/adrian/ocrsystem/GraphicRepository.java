package com.adrian.ocrsystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphicRepository extends JpaRepository<Graphic, Long> {
}
