package com.adrian.ocrsystem;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OcrController {

    private final OcrService ocrService;
    private final GraphicRepository graphicRepository;

    public OcrController(OcrService ocrService, GraphicRepository graphicRepository) {
        this.ocrService = ocrService;
        this.graphicRepository = graphicRepository;
    }

    @PostMapping("/ocr")
    public String doOcr(@RequestBody Graphic graphic) {

        String content = ocrService.doOcr(graphic.getUrl());
        graphic.setContent(content);
        graphicRepository.save(graphic);
        return content;
    }

    @GetMapping("/ocr")
    public List<Graphic> getAllGraphics() {
        return graphicRepository.findAll();
    }
}
