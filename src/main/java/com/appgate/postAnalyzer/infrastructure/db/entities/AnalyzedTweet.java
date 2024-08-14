package com.appgate.postAnalyzer.infrastructure.db.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table("analyzed_tweets")
public class AnalyzedTweet {

    @Id
    @Column("at_id")
    private Long id;

    @Column("at_score")
    private double score;

    @Column("at_message")
    private String message;

    @Column("at_tweet_url")
    private String tweetUrl;

    @Column("at_account")
    private String account;

    @Column("at_level")
    private String level;
}
