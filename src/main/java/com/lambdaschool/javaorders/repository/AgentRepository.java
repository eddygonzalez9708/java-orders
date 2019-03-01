package com.lambdaschool.javaorders.repository;

import com.lambdaschool.javaorders.models.Agents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agents, Long> {
}
