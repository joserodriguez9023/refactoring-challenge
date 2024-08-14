package com.appgate.postAnalyzer.infrastructure.db.repository;

import com.appgate.postAnalyzer.infrastructure.db.entities.AnalyzedFbPost;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AnalyzedFbPostRepository extends ReactiveCrudRepository<AnalyzedFbPost, Long> {
}
