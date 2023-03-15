package com.example.FileUploadMain.controller;

import com.example.FileUploadMain.model.Attechmaent;
import com.example.FileUploadMain.response.ResponseData;
import com.example.FileUploadMain.services.AttechmeantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class AttechmeantController {

    @Autowired
    private AttechmeantService attechmeantService;

    @PostMapping("/upload")
//    ..@RequestParam use for form data
    public ResponseData uplodeFile(@RequestParam("file")MultipartFile file) throws Exception {
        Attechmaent attechmaent=null;
        String downloadUrl="";

        attechmaent=attechmeantService.saveAttecheament(file);
        downloadUrl= ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attechmaent.getId())
                .toUriString();
        return new ResponseData(attechmaent.getFileName(),downloadUrl, file.getContentType(),file.getSize());
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attechmaent attechmaent=null;
        attechmaent=attechmeantService.getAttechament(fileId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(attechmaent.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;fileName=\""+ attechmaent.getFileName() + "\" ")
                                .body(new ByteArrayResource(attechmaent.getData()));
    }

}
