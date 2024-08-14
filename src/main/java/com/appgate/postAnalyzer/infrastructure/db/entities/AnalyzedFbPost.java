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
@Table("analyzed_fb_posts")
public class AnalyzedFbPost {
    @Id
    @Column("af_id")
    private Long id;

    @Column("af_score")
    private double score;

    @Column("af_message")
    private String message;

    @Column("af_account")
    private String account;

    @Column("af_level")
    private String level;
}
