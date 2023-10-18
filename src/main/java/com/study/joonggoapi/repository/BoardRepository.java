package com.study.joonggoapi.repository;

import com.study.joonggoapi.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
