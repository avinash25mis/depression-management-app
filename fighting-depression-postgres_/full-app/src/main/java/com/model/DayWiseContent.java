package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.common.BaseEntity;
import com.model.common.IEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "day_wise_content")
public class DayWiseContent implements IEntity {

    @Id
    @SequenceGenerator(name = "day_wise_content_id", sequenceName = "seq_day_wise_content", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "day_wise_content_id")
    private Long id;

    private Integer day;
    private String time;
    private String title;
    private String message;
    private String genre1;
    private String genre2;
    private String link;
    @Transient
    private List<Long> idList;

   @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
   @JsonIgnore
   private List<StoredFile> fileList;



}
