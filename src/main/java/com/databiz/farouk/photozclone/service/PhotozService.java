package com.databiz.farouk.photozclone.service;

import com.databiz.farouk.photozclone.model.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//@Component
@Service
public class PhotozService {

    private Map<String, Photo> db = new HashMap<>() {{
        put("1",new Photo("1","hello.jpg"));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo=new Photo();
        photo.setContentType(contentType  );
        photo.setId(java.util.UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}
