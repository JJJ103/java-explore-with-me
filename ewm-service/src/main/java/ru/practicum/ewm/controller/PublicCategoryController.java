package ru.practicum.ewm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.practicum.ewm.dto.CategoryDto;
import ru.practicum.ewm.service.PublicService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class PublicCategoryController {
    private final PublicService publicService;

    public PublicCategoryController(PublicService publicService) {
        this.publicService = publicService;
    }


}