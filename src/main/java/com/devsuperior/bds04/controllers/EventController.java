package com.devsuperior.bds04.controllers;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/events")
public class EventController {
  @Autowired
  private EventService service;

  @GetMapping
  public ResponseEntity<Page<EventDTO>> findAll(Pageable pageable) {
    PageRequest pageRequest = PageRequest.of(
      pageable.getPageNumber(),
      pageable.getPageSize(),
      Sort.by("name")
    );
    Page<EventDTO> list = service.findAll(pageRequest);
    return ResponseEntity.ok().body(list);
  }
}
