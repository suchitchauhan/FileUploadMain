package com.example.FileUploadMain.services;

import com.example.FileUploadMain.model.Attechmaent;
import org.springframework.web.multipart.MultipartFile;

public interface AttechmeantService {

    Attechmaent saveAttecheament(MultipartFile file) throws Exception;

    Attechmaent getAttechament(String fileId) throws Exception;
}
