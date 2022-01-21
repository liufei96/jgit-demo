package com.liufei.demo.controller;

import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Paths;

@RestController
@RequestMapping("/git")
public class GitController {

    @GetMapping("/gitUrl")
    public String getGitUrl() throws IOException {
        String localPath = System.getProperty("user.dir");
        Repository build = new FileRepositoryBuilder()
                .setGitDir(Paths.get(localPath, ".git").toFile())
                .build();
        return ((FileRepository)build).getConfig().getString("remote" , "origin", "url");
    }

}
