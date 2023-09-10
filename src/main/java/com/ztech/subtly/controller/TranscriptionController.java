package com.ztech.subtly.controller;

import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.ztech.subtly.utils.StorageService;
import com.ztech.subtly.utils.TranscriptionService;

@RestController
@RequestMapping(path = "/api/v1/audio")
public class TranscriptionController {
    private StorageService storageService;

    @Autowired
    public TranscriptionController() {
        this.storageService = new StorageService();
    }

    /**
     * TranscriptUpdateRequest
     * String transcript
     */
    record TranscriptUpdateRequest(String transcript) {
    }

    @PostMapping("/transcript/submit")
    public ResponseEntity<Map<String, Object>> submitFileForTranscription(@RequestParam("file") MultipartFile file) {

        return new TranscriptionService(file)
                .generateTranscript(file.getContentType());
    }

    @GetMapping(path = "/transcript/{taskId}")
    public @ResponseBody ResponseEntity<Map<String, Object>> getStatus(@PathVariable("taskId") String taskId) {
        TranscriptionService transcriptionService = new TranscriptionService(taskId);
        return transcriptionService.getStatus();
    }

    @GetMapping(path = "/transcript/{taskId}/input.srt")
    public @ResponseBody ResponseEntity<StreamingResponseBody> downloadTranscription(
            @PathVariable("taskId") String taskId,
            @RequestHeader(value = "Range", required = false) String rangeHeader) {
        String path = Paths.get(System.getProperty("user.dir"), "processing", taskId, "input.srt").toString();
        return storageService.serveMediaFile(path, rangeHeader);
    }

}