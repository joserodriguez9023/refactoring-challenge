package com.appgate.postAnalyzer.infrastructure.db.repository;

import com.appgate.postAnalyzer.infrastructure.db.entities.AnalyzedTweet;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AnalyzedTweetRepository extends ReactiveCrudRepository<AnalyzedTweet, Long> {
}
