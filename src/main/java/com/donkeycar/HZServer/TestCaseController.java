package com.donkeycar.HZServer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-cases")
public class TestCaseController {

    private final TestCaseRepository testCaseRepository;
    private TestCaseService testCaseService;

    public TestCaseController(TestCaseRepository testCaseRepository, TestCaseService testCaseService) {
        this.testCaseRepository = testCaseRepository;
        this.testCaseService = testCaseService;
    }

    @GetMapping
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com"})
    public List<TestCase> getTestCases() {
        return testCaseRepository.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com" })
    public TestCase getTestCase(@PathVariable Long id) {
        return testCaseRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com" })
    public ResponseEntity<TestCase> postTestCase(@RequestBody TestCase testCase) throws URISyntaxException {
        TestCase savedCase = testCaseRepository.save(testCase);
        return ResponseEntity.created(new URI("/test-cases/" + savedCase.getId())).body(savedCase);

    }

    @PostMapping("/{id}/run")
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com" })
    public ResponseEntity<Object> runTestCase(@PathVariable Long id) {
        TestCase currentTestCase = testCaseRepository.findById(id).orElseThrow(RuntimeException::new);
        String message = currentTestCase.toString();
        testCaseService.broadcastTestCase(message);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com" })
    public ResponseEntity<Object> updateClient(@PathVariable Long id, @RequestBody TestCase testCase) {
        TestCase currentTestCase = testCaseRepository.findById(id).orElseThrow(RuntimeException::new);
        currentTestCase.setDescription(testCase.getDescription());
        currentTestCase.setPreConditions(testCase.getPreConditions());
        currentTestCase.setPostConditions(testCase.getPostConditions());
        currentTestCase = testCaseRepository.save(currentTestCase);

        return ResponseEntity.ok(currentTestCase);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8090", "https://yassoof.github.io", "https://donkey-car.herokuapp.com" })
    public ResponseEntity<Object> deleteTestCase(@PathVariable Long id) {
        testCaseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
