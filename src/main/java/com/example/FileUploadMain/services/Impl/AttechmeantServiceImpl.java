package com.example.FileUploadMain.services.Impl;

import com.example.FileUploadMain.model.Attechmaent;
import com.example.FileUploadMain.repository.AttechmaentRspository;
import com.example.FileUploadMain.services.AttechmeantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttechmeantServiceImpl implements AttechmeantService {

    @Autowired
    private AttechmaentRspository attechmaentRspository;
    @Override
    public Attechmaent saveAttecheament(MultipartFile file) throws Exception {

        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("File Name contains invalid path sequence"+ fileName);
            }

            Attechmaent attechmaent=new Attechmaent(fileName,file.getContentType(),file.getBytes());
            return attechmaentRspository.save(attechmaent);

        }catch (Exception e){
           throw new Exception("Colud not save File : " +fileName);
        }
    }

    @Override
    public Attechmaent getAttechament(String fileId) throws Exception {
        return attechmaentRspository.findById(fileId).orElseThrow(()->new Exception("File not Found"+fileId));
    }
}
