package com.example.travelfun.dtos.request.image;


import lombok.Data;

@Data
public class UploadImageRequest {
    private String name;
    private String type;
    private byte[] imageData;

}
