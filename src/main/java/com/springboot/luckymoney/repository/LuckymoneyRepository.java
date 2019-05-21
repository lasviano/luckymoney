package com.springboot.luckymoney.repository;

import com.springboot.luckymoney.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
