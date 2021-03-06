package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FileService {

    private FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("creating FileService bean");
    }

    public void insert(File file) {
        fileMapper.insert(file);
    }

    public boolean isFileNameAvailable(String fileName, Integer userId) {
        return this.fileMapper.getFile(fileName, userId) == null;
    }

    public List<File> getAllFilesFromThisUser(Integer id) {
        return this.fileMapper.getFileFromThisUser(id);
    }

    public void deleteFile(Integer fileId) {
        this.fileMapper.deleteFile(fileId);
    }

    public File getFileById(Integer id) {
        return fileMapper.getFileById(id);
    }
}
