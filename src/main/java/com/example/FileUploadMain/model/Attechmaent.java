package com.example.FileUploadMain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name="Uplode_data")
@NoArgsConstructor
@AllArgsConstructor
public class Attechmaent {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String fileType;

    public Attechmaent(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    @Lob
    private byte[] data;

}
