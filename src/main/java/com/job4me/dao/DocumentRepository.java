package com.job4me.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job4me.entities.Document;


public interface DocumentRepository extends JpaRepository <Document,Integer> {

}
