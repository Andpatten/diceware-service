package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassPhraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diceware")
public class DicewareController {

  private final PassPhraseGenerator generator;

  @Autowired
  public DicewareController(PassPhraseGenerator generator) {
    this.generator = generator;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  String[] get(@RequestParam(value = "length", defaultValue = "6") int length) {

    return generator.passphrase(length);
  }

}

