package es.unizar.tmdad.lab1.controller;

import es.unizar.tmdad.lab1.service.TwitterLookupService;
import org.springframework.http.HttpStatus;
import org.springframework.social.UncategorizedApiException;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.web.bind.annotation.*;


@RestController
public class SearchController {

    final
    TwitterLookupService twitter;

    public SearchController(TwitterLookupService twitter) {
        this.twitter = twitter;
    }

    @RequestMapping("/search")
    public SearchResults search(@RequestParam("q") String q) {
        return twitter.search(q);
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UncategorizedApiException.class)
    public SearchResults handleUncategorizedApiException() {
        return twitter.emptyAnswer();
    }
}