package com.web2.bookbuzz.controllers;

import com.web2.bookbuzz.dto.requests.create.CreateUserBookSituationRequest;
import com.web2.bookbuzz.dto.requests.find.FindUserBookSituationRequest;
import com.web2.bookbuzz.dto.requests.update.UpdateUserBookSituationRequest;
import com.web2.bookbuzz.error.DuplicatedEntityException;
import com.web2.bookbuzz.error.EntityNotFoundException;
import com.web2.bookbuzz.services.UserBookSituationService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user_book_situation")
public class UserBookSituationController {

    private UserBookSituationService userBookSituationService;

    public UserBookSituationController(UserBookSituationService bookStatusService) {
        this.userBookSituationService = bookStatusService;
    }

    @GetMapping("/")
    public ResponseEntity<?> getBookStatus(
            @RequestParam(required = false) Integer user_id,
            @RequestParam(required = false) Integer status_id,
            @RequestParam(required = false) String book_id) {
        try {
            FindUserBookSituationRequest request = new FindUserBookSituationRequest(user_id, book_id, status_id);
            return ResponseEntity.ok().body(userBookSituationService.getAll(request));
        } 
        catch(EntityNotFoundException e) {
            return e.getError();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody CreateUserBookSituationRequest userBookSituation) {
        try {
            return ResponseEntity.ok().body(userBookSituationService.create(userBookSituation));
        } catch (DuplicatedEntityException e) {
            return e.getError();
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
            @RequestBody UpdateUserBookSituationRequest userBookSituation) {
        try {
            return ResponseEntity.ok().body(userBookSituationService.update(id, userBookSituation));
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            userBookSituationService.delete(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return e.getError();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
