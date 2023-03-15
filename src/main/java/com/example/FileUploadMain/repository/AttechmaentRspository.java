package com.example.FileUploadMain.repository;

import com.example.FileUploadMain.model.Attechmaent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttechmaentRspository extends JpaRepository<Attechmaent,String> {

}
