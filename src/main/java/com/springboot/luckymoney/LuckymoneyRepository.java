package com.springboot.luckymoney;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
